package com.ltm.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltm.web.entity.playlist.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long>{

}
