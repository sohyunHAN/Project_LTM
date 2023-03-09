package list.playlist.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import list.playlist.domain.WishList;
import list.playlist.repository.MemberRepository;
import list.playlist.repository.PlaylistRepository;
import list.playlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class WishListService {

	private final WishListRepository wishListRepository;
	private final PlaylistRepository playListRepository;
	private final MemberRepository memberRepository;
	
	public WishList saveWishList(WishList wishList) {
		return wishListRepository.save(wishList);
	}
	
	
}
