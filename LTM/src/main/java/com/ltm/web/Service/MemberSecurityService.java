package com.ltm.web.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ltm.web.constant.MemberRole;
import com.ltm.web.entity.Member;
import com.ltm.web.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
		Optional<Member> _member = this.memberRepository.findByid(id);
		if(_member.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		Member member = _member.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		if("admin".equals(id)) { //id가 admin이라면 관리자 권한을 줌
			authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
		}else {
			authorities.add(new SimpleGrantedAuthority(MemberRole.MEMBER.getValue()));
		}
		return new User(member.getId(), member.getPassword(), authorities);
	}
}