package list.playlist.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import list.playlist.domain.PlayList;
import list.playlist.domain.Song;

public interface PlaylistRepository extends JpaRepository<PlayList, Long> {
	
	// PlayList findByid(String id);
	PlayList findByTitle(String title);
	PlayList findByDiscription (String discription);
	//PlayList findByNickname (String nickname);
	PlayList findByImage (String image);
	
	Optional<PlayList> findById(Long id);
	
	Page<PlayList> findAll(Pageable pageable);
	//Pageable 객체를 입력으로 받아 Page<PlayList> 타입 객체를 리턴하는 findAll 매서드 생성
	

	@Query("select P from PlayList P where P.title like %:kw%")
	Page<PlayList> findByKeyword(@Param("kw") String kw,Pageable pageable);
}

