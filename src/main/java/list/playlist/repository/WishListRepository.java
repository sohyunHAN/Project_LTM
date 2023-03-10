package list.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import list.playlist.domain.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long>{

	//현재 로그인한 회원의 WishList 엔티티를 찾기위한 메소드 추가
	WishList findByMemberId(String memberId);
	
}
