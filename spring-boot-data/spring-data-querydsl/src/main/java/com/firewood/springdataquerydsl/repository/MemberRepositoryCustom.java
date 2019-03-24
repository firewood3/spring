package com.firewood.springdataquerydsl.repository;

import java.util.List;

public interface MemberRepositoryCustom {
    List findAllLike(String keyword);
}
