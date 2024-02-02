package com.pyro.diony.domain.member.query;

import com.pyro.diony.domain.member.entity.Member;
import com.pyro.diony.domain.member.repository.MemberRepository;
import com.pyro.diony.global.jwt.service.JwtService;
import com.pyro.diony.global.query.QueryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;

@Slf4j
@QueryService
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;


    public Member getMember(ServletRequest request)  {

        String token = jwtService.extractAccessToken((HttpServletRequest) request).orElseThrow();
        return memberRepository.findByEmail(token).orElseThrow();


//        String token = ((HttpServletRequest)request).getHeader("Authorization");
//        return memberRepository.findByEmail(jwtService.extractAccessToken(token))
//                .orElseThrow(() -> new BaseException(BaseResponseStatus.USER_NOT_FOUND));
    }


    public Long getLoginMemberId() {
        return getLoginMemberEntity().getId();
    }

    public Member getLoginMemberEntity() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("name : {}", userDetails.getUsername());
        return memberRepository.findByEmail(userDetails.getUsername()).orElseThrow(EntityNotFoundException::new);
    }
}
