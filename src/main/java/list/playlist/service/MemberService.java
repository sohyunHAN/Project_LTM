package list.playlist.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import list.playlist.domain.Member;
import list.playlist.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	public Member saveMember(Member member) {
		validateDuplicateMember(member);
		return memberRepository.save(member);
	}

	public void validateDuplicateMember(Member member) {
		Member findMembers = memberRepository.findByUserId(member.getUserId());
		if(findMembers != null) {
			throw new IllegalStateException("이미 있는 회원임.");
		}	
	}
	
	public Member findOne(Long memberId) {
		return memberRepository.findById(memberId)
				.orElseThrow(EntityNotFoundException::new);
	}
	
}
