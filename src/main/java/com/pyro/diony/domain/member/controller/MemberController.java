package com.pyro.diony.domain.member.controller;

import com.pyro.diony.domain.member.dto.MemberSignUpRequest;
import com.pyro.diony.domain.member.entity.Member;
import com.pyro.diony.domain.member.service.MemberService;
import com.pyro.diony.global.annotation.LoginUser;
import com.pyro.diony.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    final private JwtService jwtService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/oauth2/sign-up")
    public void signUp(@RequestBody MemberSignUpRequest dto, HttpServletRequest request) {
        String accessToken = jwtService.extractAccessToken(request).orElseThrow();
        String email = jwtService.extractEmail(accessToken).orElseThrow();

        log.info("job : {}", dto.getJob());
        memberService.signUp(email, dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/test")
    public String test(HttpServletRequest request) {

        return memberService.test(request);
    }

}
