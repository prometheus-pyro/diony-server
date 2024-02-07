package com.pyro.diony.domain.portfolio.entity;

import com.pyro.diony.domain.advertisement.entity.Advertisement;
import com.pyro.diony.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio extends BaseTimeEntity {
    @Id
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Advertisement advertisement;

    @Column(columnDefinition = "bigint default 0", nullable = false)
    private long view;

    @Column(columnDefinition = "bigint default 0", nullable = false)
    private long likeCount;
}
