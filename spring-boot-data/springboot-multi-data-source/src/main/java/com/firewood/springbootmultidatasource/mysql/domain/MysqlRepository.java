package com.firewood.springbootmultidatasource.mysql.domain;

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
public class MysqlRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final DataSource dataSource;
    private JdbcTemplate jdbcTemplate = null;
    private Connection connection = null;

    @Autowired
    public MysqlRepository(@Qualifier("mysqlDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void connect() throws SQLException {
        if(this.connection == null && this.jdbcTemplate == null) {
            this.connection = dataSource.getConnection();
            this.jdbcTemplate = new JdbcTemplate(dataSource);
            logger.info("mysql connected!");
        }
    }

    public boolean isConnected() throws SQLException {
        if(this.connection == null)
            return false;

        return !this.connection.isClosed();
    }

    public void disconnect() throws SQLException {
        if(this.connection != null) {
            this.connection.close();
            this.connection = null;
            this.jdbcTemplate = null;
            logger.info("mysql disconnected!");
        }
    }

    public List<MysqlNotice> findAll() {
        return jdbcTemplate.query("select * from my_notice", new MysqlNoticeMapper());
    }

    public int insert(MysqlNotice mysqlNotice) {
        return jdbcTemplate.update("insert into my_notice (id, title, content) " + "values(?,  ?, ?)",
                new Object[] { mysqlNotice.getId(), mysqlNotice.getTitle(), mysqlNotice.getContent() });
    }


    class MysqlNoticeMapper implements RowMapper<MysqlNotice> {
        @Override
        public MysqlNotice mapRow(ResultSet rs, int rowNum) throws SQLException {
            MysqlNotice mysqlNotice = new MysqlNotice();
            mysqlNotice.setId(rs.getLong("id"));
            mysqlNotice.setTitle(rs.getString("title"));
            mysqlNotice.setContent(rs.getString("content"));
            return mysqlNotice;
        }
    }
}
