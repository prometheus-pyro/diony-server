package com.pyro.diony.domain.advertisement.service;

import com.pyro.diony.domain.advertisement.dto.AdvertiseRequest;
import com.pyro.diony.domain.advertisement.dto.AudioRequest;
import com.pyro.diony.domain.advertisement.dto.response.AdvertiseResponse;
import com.pyro.diony.domain.advertisement.dto.response.AudioDetailResponse;
import com.pyro.diony.domain.advertisement.entity.Advertisement;
import com.pyro.diony.domain.advertisement.entity.Audio;
import com.pyro.diony.domain.advertisement.mapper.AdvertisementMapper;
import com.pyro.diony.domain.advertisement.mapper.AudioMapper;
import com.pyro.diony.domain.advertisement.repository.AdvertisementRepository;
import com.pyro.diony.domain.advertisement.repository.AudioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdvertisementService {
    private final AdvertisementRepository advertiseRepository;
    private final AudioRepository audioRepository;
    private final AdvertisementMapper adMapper;
    private final AudioMapper audioMapper;

    @Transactional
    public void create(AdvertiseRequest dto) {
        advertiseRepository.save(Advertisement.builder()
                .prompt(dto.getPrompt())
                .videoUrl(dto.getVideoUrl())
                .musicUrl(dto.getMusicUrl())
                .build());
    }

    @Transactional(readOnly = true)
    public AdvertiseResponse get(Long id) {
        Advertisement ad = advertiseRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return AdvertiseResponse.builder()
                .advertisement(adMapper.toResponse(ad))
                .audios(getAllAudios(ad))
                .build();
    }

    private List<AudioDetailResponse> getAllAudios(Advertisement ad) {
        List<Audio> audios = audioRepository.findAllByAdvertisement(ad);
        return audios.stream().map(a -> audioMapper.toResponse(a)).toList();
    }

    @Transactional
    public void createAudio(AudioRequest dto) {
        Advertisement ad = advertiseRepository.findById(dto.getAdvertisementId())
                .orElseThrow(EntityNotFoundException::new);

        audioRepository.save(Audio.builder()
                .location(dto.getLocation())
                .prompt(dto.getPrompt())
                .audioUrl(dto.getAudioUrl())
                .advertisement(ad)
                .build());
    }

    public List<AdvertiseResponse> getAll() {
        List<Advertisement> ads = advertiseRepository
                .findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        return ads.stream().map(ad -> AdvertiseResponse.builder()
                .advertisement(adMapper.toResponse(ad))
                .audios(getAllAudios(ad))
                .build()).toList();
    }
}
