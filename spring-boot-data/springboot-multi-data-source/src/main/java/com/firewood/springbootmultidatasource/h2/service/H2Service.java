package com.firewood.springbootmultidatasource.h2.service;

import com.firewood.springbootmultidatasource.h2.domain.H2Notice;
import com.firewood.springbootmultidatasource.h2.domain.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class H2Service {

    private final H2Repository h2Repository;

    @Autowired
    public H2Service(H2Repository h2Repository) {
        this.h2Repository = h2Repository;
    }

    public List<H2Notice> getAllNotice() {
        return h2Repository.findAll();
    }

    public boolean addNotice(H2Notice h2Notice) {
        int rs = h2Repository.insert(h2Notice);
        return rs == 1;
    }
}
