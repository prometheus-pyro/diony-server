package com.pyro.diony.domain.portfolio.repository;

import com.pyro.diony.domain.member.entity.Member;
import com.pyro.diony.domain.portfolio.entity.LikePortfolio;
import com.pyro.diony.domain.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePortfolioRepository extends JpaRepository<LikePortfolio, Long> {
    boolean existsByMemberAndPortfolio(Member member, Portfolio portfolio);

    void deleteByMemberAndPortfolio(Member member, Portfolio portfolio);
}

