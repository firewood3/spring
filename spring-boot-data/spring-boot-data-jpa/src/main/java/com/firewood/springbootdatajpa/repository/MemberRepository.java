package com.firewood.springbootdatajpa.repository;

import com.firewood.springbootdatajpa.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(@Param("name") String name);
}
