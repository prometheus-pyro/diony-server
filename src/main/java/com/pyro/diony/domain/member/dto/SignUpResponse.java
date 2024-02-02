package com.pyro.diony.domain.member.dto;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse {
    private Long id;
    private String nickname;
    private String imageUrl;
}
