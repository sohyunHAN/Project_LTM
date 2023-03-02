package com.ltm.web.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltm.web.DataNotFoundException;
import com.ltm.web.entity.Member;
import com.ltm.web.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Member create(String id, String password, String nickname, String email, String phone, String birth, LocalDateTime joindate) {
		Member member = new Member();
		member.setId(id);
		member.setPassword(passwordEncoder.encode(password));
		member.setNickname(nickname);
		member.setEmail(email);
		member.setPhone(phone);
		member.setBirth(birth); 
		member.setJoindate(LocalDateTime.now());
		
		this.memberRepository.save(member);
		return member;
	}
	
	
	// member 조회 (2023-02-27)
	public Member getMember(String id) {
		Optional<Member> member = this.memberRepository.findByid(id);
		if(member.isPresent()) {
			return member.get();
		} else {
			throw new DataNotFoundException("member not found");
		}
	}
	
}
