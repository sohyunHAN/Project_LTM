package list.playlist.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="play_list")
public class PlayList {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pl_id")
	private Long id;
	
	@Column(name="pl_title",nullable=false)
	private String title;
	
	
	private String discription;

	@Column(nullable=false)
	private String image;
	
	/*
	 * @Column(nullable=false) private String nickname;
	 */
	
	@OneToOne(mappedBy="playList",fetch=FetchType.LAZY)
	private WishList whishList;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	
	@OneToMany(mappedBy = "playList" , cascade=CascadeType.REMOVE)
	private List<PlSong> plSong = new ArrayList<>();
	
	
}