package com.pyro.diony.domain.advertisement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AudioDetailResponse {
    private Long id;
    private String prompt;
    private Integer location;
}
