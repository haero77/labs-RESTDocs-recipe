package preferkim.restdocs.domain.application;

import static org.assertj.core.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import preferkim.restdocs.config.TestConfig;
import preferkim.restdocs.config.TestProfile;
import preferkim.restdocs.domain.dao.MemberRepository;
import preferkim.restdocs.domain.dto.MemberQueryDto;
import preferkim.restdocs.domain.entity.Member;

@ActiveProfiles(TestProfile.TEST)
@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
@DataJpaTest
@Transactional
class MemberReaderTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberReader memberReader;

	@Test
	@DisplayName("회원 단건을 조회할 수 있다.")
	void read_one_member() {
		// given
		Member member = new Member("member");
		Long savedMemberId = memberRepository.save(member);

		// when
		MemberQueryDto findMember = memberReader.getOne(savedMemberId);

		// then
		assertThat(findMember.getId()).isEqualTo(member.getId());
	}
}