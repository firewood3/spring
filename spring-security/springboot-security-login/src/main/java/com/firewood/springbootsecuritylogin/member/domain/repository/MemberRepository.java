package com.firewood.springbootsecuritylogin.member.domain.repository;

import com.firewood.springbootsecuritylogin.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByMemberId(String memberId);
}
