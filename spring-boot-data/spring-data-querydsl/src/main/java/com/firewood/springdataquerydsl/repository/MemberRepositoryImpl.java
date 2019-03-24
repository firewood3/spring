package com.firewood.springdataquerydsl.repository;

import com.firewood.springdataquerydsl.entity.MemberEntity;
import com.firewood.springdataquerydsl.entity.QMemberEntity;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import java.util.List;

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {
    public MemberRepositoryImpl() {
        super(MemberEntity.class);
    }

    @Override
    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Override
    public List findAllLike(String keyword) {
        QMemberEntity qMemberEntity = QMemberEntity.memberEntity;
        JPQLQuery<MemberEntity> query = from(qMemberEntity);
        List<MemberEntity> entityList = query.where(qMemberEntity.name.like(keyword)).fetch();
        return entityList;
    }
}
