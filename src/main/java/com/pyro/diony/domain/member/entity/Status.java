package com.pyro.diony.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVE("활성"),
    IN_ACTIVE("비활성");

    private final String status;
}