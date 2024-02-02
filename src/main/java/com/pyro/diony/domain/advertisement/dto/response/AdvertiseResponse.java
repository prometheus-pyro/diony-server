package com.pyro.diony.domain.advertisement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertiseResponse {
    AdDetailResponse advertisement;
    List<AudioDetailResponse> audios;
}
