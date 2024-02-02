package com.pyro.diony.domain.member.repository;

import com.pyro.diony.domain.member.entity.Member;
import com.pyro.diony.domain.member.entity.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByOauthId(String oauthId);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByRefreshToken(String refreshToken);

    Optional<Member> findBySocialTypeAndOauthId(SocialType socialType, String oauthId);
}