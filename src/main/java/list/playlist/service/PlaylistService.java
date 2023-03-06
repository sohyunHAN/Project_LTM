package list.playlist.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import list.playlist.DataNotFoundException;
import list.playlist.domain.Member;
import list.playlist.domain.PlayList;
import list.playlist.repository.PlaylistRepository;

import org.springframework.data.jpa.domain.Specification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaylistService {

	private final PlaylistRepository playlistRepository;
	
	public Page<PlayList> getlist(int page){
		Pageable pageable = PageRequest.of(page, 2); //page는 조회할 페이지의 번호, 2는 한페이지에 보여줄 게시물의 개수
		return this.playlistRepository.findAll(pageable);
		// 목록을 조회하여 리턴하는 getlist 메서드 추가. 컨트롤러에서 레포지토리를 사용했던 부분을 그대로 옮긴 것
		//엔티티클래스와 데이터베이스가 직접맞닿아서 컨트롤러나 타임리프같은 템플릿 엔진에 전달하여 사용하는 것은 좋지 않기 때문에 서비스를 사용 
	}
	
	
	public Page<PlayList> getlistkeyword(int page , String kw){
		Pageable pageable = PageRequest.of(page, 2); //page는 조회할 페이지의 번호, 2는 한페이지에 보여줄 게시물의 개수
		return this.playlistRepository.findByKeyword(kw,pageable);	
	}
	
	
	public PlayList getPlayList(Long id) {
		Optional<PlayList> playlist = this.playlistRepository.findById(id);
		if(playlist.isPresent()) {
			return playlist.get();
		}else {
			throw new DataNotFoundException("playlist not found");
		}
	}
	
//	private Specification<PlayList> search(String kw) {
//        return new Specification<>() {
//            private static final long serialVersionUID = 1L;
//            @Override
//            public Predicate toPredicate(Root<PlayList> p, CriteriaQuery<?> query, CriteriaBuilder cb) {
//            	//Root p - PlayList의 객체 
//            	
//                query.distinct(true);  // 중복을 제거 
//                //Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT);
//                //Join<Question, Answer> a = q.join("answerList", JoinType.LEFT);
//                Join<PlayList, Member> p1 = p.join("id",JoinType.INNER);
//                return cb.or(cb.like(p1.get("id"), "%" + kw + "%")); 
//                		//cb.like(p.get("nickname"), "%" + kw + "%"));
//                		//cb.like(p.get("discription"), "%" + kw + "%"));   
//                       //cb.like(u1.get("username"), "%" + kw + "%"),   
//                       //cb.like(a.get("content"), "%" + kw + "%"),       
//                        //cb.like(u2.get("username"), "%" + kw + "%"));   
//            }
//        };
//    }
	
	
	
}
