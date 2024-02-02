package com.pyro.diony.domain.advertisement.entity;

import com.pyro.diony.domain.member.entity.Member;
import com.pyro.diony.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Advertisement extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prompt;
    private String musicUrl;
    private String videoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Advertisement(Member member, String prompt, String musicUrl, String videoUrl) {
        this.member = member;
        this.prompt = prompt;
        this.musicUrl = musicUrl;
        this.videoUrl = videoUrl;
    }
}
