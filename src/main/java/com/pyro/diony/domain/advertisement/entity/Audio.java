package com.pyro.diony.domain.advertisement.entity;

import com.pyro.diony.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Audio extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prompt;
    private Integer location;  //audio 위치

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;

    @Builder
    public Audio(String prompt, Integer location, Advertisement advertisement) {
        this.prompt = prompt;
        this.location = location;
        this.advertisement = advertisement;
    }

}
