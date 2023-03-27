package preferkim.restdocs.config;

import javax.persistence.EntityManager;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import preferkim.restdocs.domain.application.MemberReader;
import preferkim.restdocs.domain.dao.MemberRepository;

@TestConfiguration
public class TestConfig {

	@Bean
	public MemberRepository memberRepository(
		EntityManager entityManager
	) {
		return new MemberRepository(entityManager);
	}

	@Bean
	public MemberReader memberReader(
		MemberRepository memberRepository
	) {
		return new MemberReader(memberRepository);
	}
}
