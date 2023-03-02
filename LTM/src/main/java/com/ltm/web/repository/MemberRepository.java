package com.ltm.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltm.web.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	Optional<Member> findByid(String id);
}
