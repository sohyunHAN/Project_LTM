package list.playlist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Wish")
public class Wish{
   //위시리스트 아이템 엔티티
	@Id
	@GeneratedValue
	@Column(name="wish_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="wl_id")
	private WishList wishList; //위시리스트
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pl_id")
	private PlayList playList; //플레이리스트
	
	private int count;
	
	//위시리스트에 담을 플레이리스트 엔티티를 생성하는 메소드
	public static Wish createWishItem(WishList wishList, PlayList playList) {
		Wish wish = new Wish();
		wish.setWishList(wishList);
		wish.setPlayList(playList);
		return wish;
	}
}
