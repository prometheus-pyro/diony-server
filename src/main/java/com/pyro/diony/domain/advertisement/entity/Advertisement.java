package com.pyro.diony.domain.advertisement.entity;

import com.pyro.diony.global.config.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Builder
    public Advertisement(String prompt, String musicUrl, String videoUrl) {
        this.prompt = prompt;
        this.musicUrl = musicUrl;
        this.videoUrl = videoUrl;
    }
}
