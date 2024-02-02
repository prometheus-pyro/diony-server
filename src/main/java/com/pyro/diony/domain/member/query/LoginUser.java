package com.pyro.diony.domain.member.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    Long id;
    Long oauthId;
    Long nickname;
    Long email;
}
