package com.firewood.springbootmultidatasource.h2.domain;

import com.firewood.springbootmultidatasource.pg.domain.PgNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class H2Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public H2Repository(@Qualifier("h2DataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("create table h2_notice" +
                "(" +
                "   id integer not null," +
                "   title varchar(255) not null," +
                "   content varchar(255) not null," +
                "   primary key(id)" +
                ");");

        jdbcTemplate.execute("insert into h2_notice " +
                "values(1,'h2-title-1', 'h2-content-1');");
        jdbcTemplate.execute("insert into h2_notice " +
                "values(2,'h2-title-2', 'h2-content-2');");
        jdbcTemplate.execute("insert into h2_notice " +
                "values(3,'h2-title-3', 'h2-content-3');");
    }

    public List<H2Notice> findAll() {
        return jdbcTemplate.query("select * from h2_notice", new H2NoticeMapper());
    }

    public int insert(H2Notice h2Notice) {
        return jdbcTemplate.update("insert into h2_notice (id, title, content) " + "values(?,  ?, ?)",
                new Object[] { h2Notice.getId(), h2Notice.getTitle(), h2Notice.getContent() });
    }

    class H2NoticeMapper implements RowMapper<H2Notice> {
        @Override
        public H2Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
            H2Notice h2Notice= new H2Notice();
            h2Notice.setId(rs.getLong("id"));
            h2Notice.setTitle(rs.getString("title"));
            h2Notice.setContent(rs.getString("content"));
            return h2Notice;
        }
    }
}
