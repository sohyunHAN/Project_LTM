package list.playlist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="wish_list")
public class WishList {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wl_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id") 
	private Member member;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "pl_id")
//	private PlayList playList;


	public static WishList createWish(Member member) {
		//회원 한명당 1개의 wishlist 를 가지므로 처음 상품을 담을때는 해당 회원의 wishlist
		//WishList 엔티티에 회원 엔티티를 파라미터로 받아서 wishlist엔티티 생성로직
		WishList wishList = new WishList();
		wishList.setMember(member);
		return wishList;
	}
}
