package com.firewood.springbootsecuritylogin.member.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberId;
    private String password;
    private String memberRole;
    private String email;
    private String phoneNumber;


    protected Member() {}

    public Member(String memberId, String password, String memberRole, String email, String phoneNumber) {
        this.memberId = memberId;
        this.password = password;
        this.memberRole = memberRole;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
