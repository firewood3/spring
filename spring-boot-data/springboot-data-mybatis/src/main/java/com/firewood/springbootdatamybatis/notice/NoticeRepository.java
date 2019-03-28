package com.firewood.springbootdatamybatis.notice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NoticeRepository {
    private static final String MAPPER_NAME_SPACE = "mapper.noticeMapper.";

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public NoticeRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List findAllNotice() {
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "findAllNotice");
    }

    public Notice findById(Long id) {
        Map<String,Object> params = new HashMap();
        params.put("id", id);

        return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "findNoticeById", params);
    }

    public void addNotice(Notice notice) {
        sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "addNotice", notice);
    }
}
