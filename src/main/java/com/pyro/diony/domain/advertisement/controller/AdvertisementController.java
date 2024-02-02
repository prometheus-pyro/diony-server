package com.pyro.diony.domain.advertisement.controller;

import com.pyro.diony.domain.advertisement.dto.AdvertiseRequest;
import com.pyro.diony.domain.advertisement.dto.AudioRequest;
import com.pyro.diony.domain.advertisement.dto.response.AdvertiseResponse;
import com.pyro.diony.domain.advertisement.service.AdvertisementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/advertisement")
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createAd(@RequestBody @Valid final AdvertiseRequest dto) {
        advertisementService.create(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{adId}")
    public AdvertiseResponse getAd(@PathVariable final Long adId) {
        return advertisementService.get(adId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/audio")
    public void createAudio(@RequestBody @Valid final AudioRequest dto) {
        advertisementService.createAudio(dto);
    }
}
