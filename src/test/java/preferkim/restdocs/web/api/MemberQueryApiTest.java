package preferkim.restdocs.web.api;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import preferkim.restdocs.domain.dao.MemberRepository;
import preferkim.restdocs.domain.entity.Member;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
@Transactional
class MemberQueryApiTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MemberRepository memberRepository;

	@Test
	@DisplayName("회원 단건 조회")
	void get_one_member() throws Exception {
		// given
		Long savedMemberId = memberRepository.save(new Member("member"));

		// when & then
		ResultActions resultActions = mockMvc.perform(
				get("/api/members/{memberId}", savedMemberId)
					.contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk());

		// REST Docs
		resultActions.andDo(
			document("member-get-one",
				pathParameters(
					parameterWithName("memberId").description("회원 ID")
				),
				responseFields(
					fieldWithPath("id").description("회원 ID"),
					fieldWithPath("name").description("회원 이름")
				)
			)
		);
	}
}