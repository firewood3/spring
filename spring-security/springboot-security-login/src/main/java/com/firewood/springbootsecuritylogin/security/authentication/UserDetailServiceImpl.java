package com.firewood.springbootsecuritylogin.security.authentication;

import com.firewood.springbootsecuritylogin.member.domain.repository.MemberRepository;
import com.firewood.springbootsecuritylogin.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public UserDetailServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) {
        Member member = memberRepository.findMemberByMemberId(memberId);
        if (ObjectUtils.isEmpty(member))
            throw new UsernameNotFoundException("아이디 또는 비밀번호를 확인해 주세요.");
        return new AuthorityMember(member);
    }
}
