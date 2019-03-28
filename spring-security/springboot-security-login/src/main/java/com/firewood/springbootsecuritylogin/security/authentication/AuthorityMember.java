package com.firewood.springbootsecuritylogin.security.authentication;

import com.firewood.springbootsecuritylogin.member.domain.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;


public class AuthorityMember extends User {

    public AuthorityMember(Member member) {
        super(member.getMemberId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getMemberRole()));
    }
}
