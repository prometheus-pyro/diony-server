package com.pyro.diony.domain.advertisement.service;

import com.pyro.diony.domain.advertisement.dto.AdvertiseRequest;
import com.pyro.diony.domain.advertisement.dto.AudioRequest;
import com.pyro.diony.domain.advertisement.dto.response.AdDetailResponse;
import com.pyro.diony.domain.advertisement.dto.response.AdvertiseResponse;
import com.pyro.diony.domain.advertisement.dto.response.AudioDetailResponse;
import com.pyro.diony.domain.advertisement.entity.Advertisement;
import com.pyro.diony.domain.advertisement.entity.Audio;
import com.pyro.diony.domain.advertisement.repository.AdvertisementRepository;
import com.pyro.diony.domain.advertisement.repository.AudioRepository;
import com.pyro.diony.domain.member.entity.Member;
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
        log.info("advertisement id : {}", ad.getId());

        final Member member = ad.getMember();
        return AdvertiseResponse.builder()
                .advertisement(AdDetailResponse.builder()
                        .id(ad.getId())
                        .prompt(ad.getPrompt())
                        .videoUrl(ad.getVideoUrl())
                        .musicUrl(ad.getMusicUrl())
                        .build()
                )
                .audios(getAllAudios(ad))
                .build();
    }

    private List<AudioDetailResponse> getAllAudios(Advertisement ad) {
        List<Audio> audios = audioRepository.findAllByAdvertisement(ad);
        return audios.stream().map(a -> AudioDetailResponse.builder()
                .id(a.getId())
                .location(a.getLocation())
                .audioUrl(a.getAudioUrl())
                .prompt(a.getPrompt())
                .build()
        ).toList();
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

    @Transactional(readOnly = true)
    public List<AdvertiseResponse> getAll() {
        List<Advertisement> ads = advertiseRepository
                .findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        return ads.stream().map(ad -> AdvertiseResponse.builder()
                .advertisement(AdDetailResponse.builder()
                        .id(ad.getId())
                        .prompt(ad.getPrompt())
                        .videoUrl(ad.getVideoUrl())
                        .musicUrl(ad.getMusicUrl())
                        .build())
                .audios(getAllAudios(ad))
                .build()).toList();
    }
}
