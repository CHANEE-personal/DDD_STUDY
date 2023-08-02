package org.toy_project.member.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.toy_project.member.adapter.out.Member;
import org.toy_project.member.application.port.in.JoinMemberUseCase;
import org.toy_project.member.domain.MemberEntity;
import reactor.core.publisher.Mono;

@DisplayName("회원 관련 api")
@AutoConfigureRestDocs
@WebMvcTest(controllers = MemberController.class, properties = {
        "spring.config.location=classpath:application-test.yml"})
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JoinMemberUseCase joinMemberUseCase;


    @Test
    @DisplayName("회원 가입")
    void joinMemberTest() throws Exception {
        // given
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserName("test");
        memberEntity.setUserId("test");
        memberEntity.setPassword("test");
        memberEntity.setUserPhone("010-1234-5678");
        memberEntity.setSex("m");
        memberEntity.setBirthday("1999-09-09");
        memberEntity.setAddress("인천");
        memberEntity.setEmail("test@naver.com");

        Member joinMember = new Member();
        joinMember.setUserName("test");
        joinMember.setUserId("test");
        joinMember.setPassword("test");
        joinMember.setUserPhone("010-1234-5678");
        joinMember.setSex("m");
        joinMember.setBirthday("1999-09-09");
        joinMember.setAddress("인천");
        joinMember.setEmail("test@naver.com");

        given(joinMemberUseCase.joinMember(memberEntity)).willReturn(Mono.just(joinMember));

        // when
        mockMvc.perform(post("/member").contentType(APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(memberEntity))).andDo(print());
    }
}
