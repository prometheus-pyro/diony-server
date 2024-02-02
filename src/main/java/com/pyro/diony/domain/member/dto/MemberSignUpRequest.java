package com.pyro.diony.domain.member.dto;

import com.pyro.diony.domain.member.entity.Member;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MemberSignUpRequest {

    @NotEmpty
    private String introduction;
    @NotEmpty
    private String job;


}
