package com.pyro.diony.domain.member.mapper;

import com.pyro.diony.domain.member.dto.SignUpResponse;
import com.pyro.diony.domain.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    SignUpResponse toResponse(Member member);



}
