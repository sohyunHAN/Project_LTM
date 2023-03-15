package com.ltm.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltm.web.Dto.WishListFormDto;
import com.ltm.web.Service.MemberService;
import com.ltm.web.Service.PlayListService;
import com.ltm.web.Service.WishListService;
import com.ltm.web.entity.Member;
import com.ltm.web.entity.playlist.PlayList;
import com.ltm.web.entity.playlist.WishList;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WishListController {

	private final WishListService wishListService;
	private final MemberService memberService;
	private final PlayListService playListService;
	
	//플레이리스트를 위시리스트에 넣을 때
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/getwishlist")
	public String getWishList(@RequestParam("plId") Long plId, Principal principal) {
		
		//로그인된 회원 조회
		Member member = this.memberService.getMember(principal.getName());

		wishListService.saveWishList(member.getId(), plId);
		
		return "redirect:/"; 
	}

	
		//@PreAuthorize("isAuthenticated()")
		@GetMapping("/wishlist")
		public String viewWishList(
				@RequestParam(value="memberId",required=false) String memberId,
				Principal principal,Model model) {
			//required=false로 해당 parameter를 반드시 받지 않아도 됨
			
			Member member = this.memberService.getMember(principal.getName());
			//PlayList playList = this.playListService.findOne(plId);
			//내 위시리스트 조회
			List<WishList> myWishList = wishListService.findPlSongs(member.getId());
		
			model.addAttribute("myWishList", myWishList);
			
			return "playlist/WishList";
		}
	
//	//내 위시리스트 페이지
//	@GetMapping("/wishlist")
//	public String showWishList() {
//		
//	}
}
