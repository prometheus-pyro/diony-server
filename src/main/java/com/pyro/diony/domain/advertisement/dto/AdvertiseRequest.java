package com.pyro.diony.domain.advertisement.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseRequest {
    String prompt;
    String musicUrl;
    String videoUrl;
}
