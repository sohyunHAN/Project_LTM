package list.playlist.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import list.playlist.domain.PlSong;

public interface PlSongRepository extends JpaRepository<PlSong, Long>{

	PlSong findByid(Long id);
	
}
