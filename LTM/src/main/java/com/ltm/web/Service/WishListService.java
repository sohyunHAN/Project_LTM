package com.ltm.web.Service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ltm.web.entity.playlist.WishList;
import com.ltm.web.repository.WishListRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class WishListService {

	private final WishListRepository wishListRepository;
	
	public WishList saveWishList(WishList wishList) {
		return wishListRepository.save(wishList);
	}
}
