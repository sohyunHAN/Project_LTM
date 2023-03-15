package com.ltm.web.Service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltm.web.entity.Member;
import com.ltm.web.entity.playlist.PlayList;
import com.ltm.web.entity.playlist.WishList;
import com.ltm.web.repository.WishListRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class WishListService {

	private final WishListRepository wishListRepository;
	private final PlayListService playListService;
	private final MemberService memberService;
	
	public WishList saveWishList(String memberId, Long plId) {
		
		//플레이리스트 조회
		PlayList selectPlayList = playListService.findOne(plId);
		
		//회원 조회
		Member selectMemeber = memberService.getMember(memberId);
		
		//위시리스트에 넣어주기. 준영속
		WishList saveWishList = WishList.createWishList(selectPlayList, selectMemeber);
		
		//저장
		return wishListRepository.save(saveWishList);
	}
	
	//위시리스트 조회
	@Transactional(readOnly = true)
	public List<WishList> findPlSongs(String memberId){
		return wishListRepository.findWishList(memberId);
	}
	
	
}
