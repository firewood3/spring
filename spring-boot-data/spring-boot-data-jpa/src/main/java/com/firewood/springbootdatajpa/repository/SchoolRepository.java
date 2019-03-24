package com.firewood.springbootdatajpa.repository;

import com.firewood.springbootdatajpa.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
