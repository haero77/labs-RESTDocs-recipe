package preferkim.restdocs.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import preferkim.restdocs.domain.application.MemberReader;
import preferkim.restdocs.domain.dto.MemberQueryDto;

@RestController
@RequiredArgsConstructor
public class MemberQueryApi {

	private final MemberReader memberReader;

	@GetMapping("/api/members/{memberId}")
	public ResponseEntity<MemberQueryDto> getOne(
		@PathVariable Long memberId
	) {
		MemberQueryDto response = memberReader.getOne(memberId);
		return ResponseEntity.ok(response);
	}
}
