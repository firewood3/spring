package com.firewood.springbootmultidatasource.mysql.service;

import com.firewood.springbootmultidatasource.mysql.domain.MysqlNotice;
import com.firewood.springbootmultidatasource.mysql.domain.MysqlRepository;
import com.firewood.springbootmultidatasource.pg.domain.PgNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class MysqlService {

    private final MysqlRepository mysqlRepository;

    @Autowired
    public MysqlService(MysqlRepository mysqlRepository) {
        this.mysqlRepository = mysqlRepository;
    }

    public boolean isConnected() {
        try {
            return mysqlRepository.isConnected();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<List<MysqlNotice>> getAllNotice() {
        if(isConnected())
            return Optional.of(mysqlRepository.findAll());
        else
            return Optional.empty();
    }

    public boolean connect(){
        if(isConnected()) {
            return true;
        }
        else {
            try {
                mysqlRepository.connect();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public boolean disconnect() {
        if(isConnected()) {
            try {
                mysqlRepository.disconnect();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return true;
        }
    }

    public boolean addNotice(MysqlNotice mysqlNotice) {
        int rs = mysqlRepository.insert(mysqlNotice);
        return rs == 1;
    }
}
