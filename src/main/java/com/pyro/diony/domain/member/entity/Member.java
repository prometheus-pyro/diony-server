package com.pyro.diony.domain.member.entity;


import com.pyro.diony.domain.member.dto.MemberSignUpRequest;
import com.pyro.diony.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;  //로그인한 소셜 타입의 식별자 값
    private String nickname;
    private String email;
    private String password;
    private String imageUrl;

    private String introduction;
    private String job;

    private String refreshToken;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Member update(String email, String imageUrl) {
        this.email = email;
        this.imageUrl = imageUrl;
        return this;
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }

    public void signUp(MemberSignUpRequest dto) {
        this.introduction = dto.getIntroduction();
        this.job = dto.getJob();
        this.role = Role.USER;
    }
}