package com.pyro.diony.domain.member.service;

import com.pyro.diony.domain.member.dto.MemberSignUpRequest;
import com.pyro.diony.domain.member.entity.Member;
import com.pyro.diony.domain.member.query.AuthService;
import com.pyro.diony.domain.member.repository.MemberRepository;
import com.pyro.diony.global.jwt.service.JwtService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
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
    private final JwtService jwtService;
    private final MemberRepository memberRepository;

    @Transactional
    public void signUp(String email, MemberSignUpRequest dto) {
        Member member = memberRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        member.signUp(dto);
    }

    public Member getMember(HttpServletRequest request) {
        String accessToken = jwtService.extractAccessToken(request).orElseThrow();
        String email = jwtService.extractEmail(accessToken).orElseThrow();
        return memberRepository.findByEmail(email).orElseThrow();
    }

    public String test(HttpServletRequest request) {
        return getMember(request).getEmail();
    }
}
