package com.pyro.diony.domain.advertisement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AudioRequest {
    private Long advertisementId;
    private String prompt;
    private Integer location;
}
