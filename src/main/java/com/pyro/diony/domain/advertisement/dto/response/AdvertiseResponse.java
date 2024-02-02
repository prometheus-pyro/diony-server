package com.pyro.diony.domain.advertisement.dto.response;

import com.pyro.diony.domain.member.entity.Member;
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
    Long memberId;
    String profileImgUrl;
    String introduction;
    String nickname;
    AdDetailResponse advertisement;
    List<AudioDetailResponse> audios;
}
