package com.pyro.diony.domain.member.service;

import com.pyro.diony.domain.member.dto.SignUpResponse;
import com.pyro.diony.domain.member.entity.Member;
import com.pyro.diony.domain.member.mapper.MemberMapper;
import com.pyro.diony.domain.member.query.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final AuthService authService;
    private final MemberMapper memberMapper;

    public String signUp() {
        return "hello";
//        return memberMapper.toResponse(authService.getLoginMemberEntity());
    }
}
