package list.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import list.playlist.domain.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long>{

}
