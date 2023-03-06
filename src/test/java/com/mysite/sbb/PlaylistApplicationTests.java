package com.mysite.sbb;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import list.playlist.domain.PlayList;
import list.playlist.repository.PlaylistRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class PlaylistApplicationTests {
	
	@Autowired
	private PlaylistRepository playlistrepository;
	
	

	@Test
	@DisplayName("테스트")
	void test() {
		
//		PlayList pl = new PlayList();
//		pl.setId(10);
//		pl.setDiscription("asss");
//		pl.setNickname("Rtrt");
//		pl.setTitle("yyy");
//		pl.setImage("cover3.jpg");
//		PlayList savedPlayList = playlistrepository.save(pl);
//		System.out.println(savedPlayList.toString());
//		
		List<PlayList> all = this.playlistrepository.findAll();
		assertEquals(2,all.size());
		
//		PlayList P = all.get(0);
//		assertEquals("abc", P.getNickname());
	}

}
