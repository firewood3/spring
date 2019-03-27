package com.firewood.springbootmultidatasource.pg.service;

import com.firewood.springbootmultidatasource.pg.domain.PgNotice;
import com.firewood.springbootmultidatasource.pg.domain.PgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PgService {

    private final PgRepository pgRepository;

    @Autowired
    public PgService(PgRepository pgRepository) {
        this.pgRepository = pgRepository;
    }

    public boolean isConnected() {
        try {
            return pgRepository.isConnected();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<List<PgNotice>> getAllNotice() {
        if(isConnected())
            return Optional.of(pgRepository.findAll());
        else
            return Optional.empty();
    }

    public boolean connect(){
        if(isConnected()) {
            return true;
        }
        else {
            try {
                pgRepository.connect();
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
                pgRepository.disconnect();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return true;
        }
    }

    public boolean addNotice(PgNotice pgNotice) {
        int rs = pgRepository.insert(pgNotice);
        return rs == 1;
    }
}
