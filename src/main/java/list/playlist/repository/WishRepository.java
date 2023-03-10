package list.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import list.playlist.domain.Wish;

public interface WishRepository extends JpaRepository<Wish,Long>{

	//wishListId와 playListId를 이용해서 플레이리스트가 위시리스트에 들어있는지 조회
	Wish findByWishListIdAndPlayListId(Long wishListId,Long playListId);
}
