package org.toy_project.member.adapter.in.web;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.toy_project.account.adapter.in.web.AccountController;
import org.toy_project.account.adapter.in.web.AccountControllerDocs;
import org.toy_project.account.application.port.in.GetAccountUseCase;
import org.toy_project.member.application.port.in.JoinMemberUseCase;

@DisplayName("회원 관련 api")
@AutoConfigureRestDocs
@WebMvcTest(controllers = MemberController.class, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE)})
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JoinMemberUseCase joinMemberUseCase;


    @Test
    @DisplayName("회원 가입")
    void joinMemberTest() throws Exception {
        mockMvc.perform(post("/member")).andDo(MemberControllerDocs.joinMember()).andDo(print());
    }
}
