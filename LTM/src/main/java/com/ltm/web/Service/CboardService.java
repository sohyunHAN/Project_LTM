package com.ltm.web.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ltm.web.DataNotFoundException;
import com.ltm.web.entity.Cboard;
import com.ltm.web.entity.Member;
import com.ltm.web.repository.CboardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CboardService {
	
	private final CboardRepository cboardRepository;
		
		/*게시글 조회*/
		public List<Cboard> getList(){
			return this.cboardRepository.findAll();
		}
		
		public Cboard getCboard(Integer id) {
			Optional<Cboard> cboard = this.cboardRepository.findById(id);
			if(cboard.isPresent()) {
				return cboard.get();
			} else {
				throw new DataNotFoundException("cboard not found");
			}
		}
			
		/*게시글 등록*/
		public void create(String ctitle, String cbody, Member user, String tags) {
			Cboard c = new Cboard();
			c.setCtitle(ctitle);
			c.setCbody(cbody);
			c.setWdate(LocalDateTime.now());
			c.setNickname(user); // 작성자 : user
			c.setTags(tags); // 해시태그 
			this.cboardRepository.save(c);
		}
		
		/*게시글 페이징*/
		public Page<Cboard> getList(int page){
			List<Sort.Order> sorts = new ArrayList<>(); 
			sorts.add(Sort.Order.desc("wdate")); // 작성일 역순
			Pageable pageable = PageRequest.of(page, 20 , Sort.by(sorts));
			return this.cboardRepository.findAll(pageable);
		}
		
		
		
		/*게시글 수정*/
		public void modify(Cboard cboard, String ctitle, String cbody, String tags) {
			cboard.setCtitle(ctitle);
			cboard.setCbody(cbody);
			cboard.setMdate(LocalDateTime.now());
			cboard.setTags(tags);
			this.cboardRepository.save(cboard);
		}
		
		/*게시글 삭제*/
		public void delete(Cboard cboard) {
			this.cboardRepository.delete(cboard);
		}
		
		/*게시글 조회수*/
		@Transactional
		public int updateView(Integer id) {
			return this.cboardRepository.updateView(id);
		}
		
		/*게시글 추천*/
		public void vote(Cboard cboard, Member member) {
			cboard.getVoter().add(member);
			this.cboardRepository.save(cboard);
		}
}
