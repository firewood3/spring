package com.firewood.springbootmultidatasource.pg.domain;

import com.firewood.springbootmultidatasource.mysql.domain.MysqlNotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PgRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final DataSource dataSource;
    private JdbcTemplate jdbcTemplate = null;
    private Connection connection = null;

    @Autowired
    public PgRepository(@Qualifier("pgDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void connect() throws SQLException {
        this.connection = dataSource.getConnection();
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        logger.info("pgsql connected!");
    }

    public boolean isConnected() throws SQLException {
        if(this.connection == null)
            return false;

        return !this.connection.isClosed();
    }

    public void disconnect() throws SQLException {
        this.connection.close();
        this.connection = null;
        this.jdbcTemplate = null;
        logger.info("pgsql disconnected!");
    }

    public List<PgNotice> findAll() {
        return jdbcTemplate.query("select * from pg_notice", new PgRepository.PgNoticeMapper());
    }

    public int insert(PgNotice pgNotice) {
        return jdbcTemplate.update("insert into pg_notice (id, title, content) " + "values(?,  ?, ?)",
                new Object[] { pgNotice.getId(), pgNotice.getTitle(), pgNotice.getContent() });
    }

    class PgNoticeMapper implements RowMapper<PgNotice> {
        @Override
        public PgNotice mapRow(ResultSet rs, int rowNum) throws SQLException {
            PgNotice pgNotice = new PgNotice();
            pgNotice.setId(rs.getLong("id"));
            pgNotice.setTitle(rs.getString("title"));
            pgNotice.setContent(rs.getString("content"));
            return pgNotice;
        }
    }
}
