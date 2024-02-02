package com.pyro.diony.domain.member.controller;

import com.pyro.diony.domain.member.dto.SignUpResponse;
import com.pyro.diony.domain.member.service.MemberService;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/login/oauth2/code/user/sign-up")
    public String getAll() {
        log.info("get all member");
        return memberService.signUp();
    }
}
