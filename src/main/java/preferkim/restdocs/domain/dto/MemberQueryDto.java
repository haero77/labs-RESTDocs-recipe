package preferkim.restdocs.domain.dto;

import lombok.Getter;
import preferkim.restdocs.domain.entity.Member;

@Getter
public class MemberQueryDto {

	private final Long id;
	private final String name;

	private MemberQueryDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public static MemberQueryDto from(Member member) {
		return new MemberQueryDto(member.getId(), member.getName());
	}
}
