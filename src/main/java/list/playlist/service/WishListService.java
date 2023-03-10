package list.playlist.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import list.playlist.domain.Member;
import list.playlist.domain.PlayList;
import list.playlist.domain.Wish;
import list.playlist.domain.WishList;
import list.playlist.dto.WishDto;
import list.playlist.repository.MemberRepository;
import list.playlist.repository.PlaylistRepository;
import list.playlist.repository.WishListRepository;
import list.playlist.repository.WishRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class WishListService {

	private final WishListRepository wishListRepository;
	private final PlaylistRepository playListRepository;
	private final MemberRepository memberRepository;
	private final WishRepository wishRepository;
	
	public Long addWishList(WishDto wishDto, String userId ) {
		//위시리스트에 담을 플레이리스트 엔티티를 조회
		PlayList playList = playListRepository.findById(wishDto.getPlayListId())
							.orElseThrow(EntityNotFoundException::new);
		//현재 로그인한 회원의 엔티티를 조회
		Member member = memberRepository.findByUserId(userId);
		
		//현재 로그인한 회원의 위시리스트 엔티티를 조회
		WishList wishList = wishListRepository.findByMemberId(member.getUserId());
		
		//플레이리스트를 처음으로 위시리스트에 담을 경우 해당 회원의 위시리스트 엔티티를 생성
		if(wishList == null) {
			wishList = WishList.createWish(member); ////createWish 메소드는 static으로 생성되어있음
			wishListRepository.save(wishList);
		}
		//현재 플레이리스트가 이미 위시리스트에 들어가있는지 조회
		Wish savedWish = wishRepository.findByWishListIdAndPlayListId(wishList.getId(),playList.getId());
		if(savedWish !=null) {
			// 위시리스트에 이미 있던 플레이리스트일 경우 이미 있다는 메세지 출력되야함
			return savedWish.getId();
		}else {
			//위시리스트에 플레이리스트가 없을경우 위시리스트에 담겨야함 wish엔티티 생성
			Wish wish = Wish.createWishItem(wishList, playList);
			//장바구니할때는 count가 포함되었었음..
			
			//위시리스트에 들어갈 플레이리스트 저장
			wishRepository.save(wish);
			return wish.getId();
		}
		
	}
	
//	public WishList saveWishList(WishList wishList) {
//		return wishListRepository.save(wishList);
//	}
	
	
}
