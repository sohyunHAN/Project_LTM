package com.ltm.web.Dto;

import com.ltm.web.entity.Member;
import com.ltm.web.entity.playlist.PlayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishListFormDto {

	private PlayList playList;
	
	private Member member;

//	@Override
//	public String toString() {
//		return "WishListFormDto [playList=" + playList + ", member=" + member + "]";
//	}

//	public WishListFormDto(PlayList playList, Member member) {
//		//super();
//		this.playList = playList;
//		this.member = member;
//	}
	
	
}
