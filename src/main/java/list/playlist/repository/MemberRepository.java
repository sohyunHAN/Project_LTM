package list.playlist.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import list.playlist.domain.Member;


public interface MemberRepository extends JpaRepository<Member, Long>{

	Member findByUserId(String userId);
	
}
