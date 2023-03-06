package list.playlist.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import list.playlist.domain.Member;
import list.playlist.domain.PlSong;
import list.playlist.domain.PlayList;
import list.playlist.domain.Song;
import list.playlist.repository.MemberRepository;
import list.playlist.repository.PlSongRepository;
import list.playlist.repository.PlaylistRepository;
import list.playlist.repository.SongRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PlSongService {

	private final PlaylistRepository playListRepository;
	private final SongRepository songRepository; 
	private final PlSongRepository plSongRepository;
	
	@Transactional
	public Long plSong(Long plId,Long songId) {
		//엔티티 조회
		Song song = songRepository.findById(songId)
				.orElseThrow(EntityNotFoundException::new);
		PlayList playList = playListRepository.findById(plId)
				.orElseThrow(EntityNotFoundException::new);

		//플레이리스트를 연결해주는 노래 저장 공간 생성
		PlSong plSong = PlSong.createPlSong(playList,song);
		
		//저장
		plSongRepository.save(plSong);
		
		return plSong.getId();
		
	}
}
