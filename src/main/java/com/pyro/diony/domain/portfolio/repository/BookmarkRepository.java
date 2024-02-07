package com.pyro.diony.domain.portfolio.repository;

import com.pyro.diony.domain.member.entity.Member;
import com.pyro.diony.domain.portfolio.entity.Bookmark;
import com.pyro.diony.domain.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Long, Bookmark> {
    boolean existsByMemberAndPortfolio(Member member, Portfolio portfolio);

    void deleteByMemberAndPortfolio(Member member, Portfolio portfolio);
}
