package preferkim.restdocs.domain.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import preferkim.restdocs.domain.entity.Member;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	private final EntityManager em;

	public Long save(Member member) {
		em.persist(member);
		return member.getId();
	}

	public Member findById(Long memberId) {
		return em.createQuery("""
				select m
				from Member m
				where m.id = :id""", Member.class)
			.setParameter("id", memberId)
			.getSingleResult();
	}
}
