package preferkim.restdocs.domain.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import preferkim.restdocs.domain.dao.MemberRepository;
import preferkim.restdocs.domain.dto.MemberQueryDto;
import preferkim.restdocs.domain.entity.Member;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberReader {

	private final MemberRepository memberRepository;

	public MemberQueryDto getOne(Long memberId) {
		Member findMember = memberRepository.findById(memberId);
		return MemberQueryDto.from(findMember);
	}
}
