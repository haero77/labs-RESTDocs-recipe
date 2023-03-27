package preferkim.restdocs.domain.entity;

import static javax.persistence.GenerationType.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Member {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	private String name;

	protected Member() {
	}

	public Member(String name) {
		this.name = name;
	}
}
