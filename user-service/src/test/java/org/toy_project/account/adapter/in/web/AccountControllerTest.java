package org.toy_project.account.adapter.in.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.toy_project.account.adapter.out.persistence.Account;
import org.toy_project.account.adapter.out.persistence.AccountImage;
import org.toy_project.account.application.port.in.GetAccountUseCase;

@DisplayName("계정 관련 api")
@AutoConfigureRestDocs
@WebMvcTest(controllers = AccountController.class, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE)})
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetAccountUseCase getAccountUseCase;


    @BeforeEach
    void init() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("jennierubyjane");
        account.setHashTag("@lesyeuxdenini");
        account.setYoutubeUrl("https://youtu.be/JyBd-qPKqpU");
        account.setPostCount(999);
        account.setFollowCount(999);
        account.setFollowerCount(999);

        AccountImage accountImage = new AccountImage();
        accountImage.setId(1L);
        accountImage.setType("profile");
        accountImage.setImageUrl(
                "https://scontent-ssn1-1.cdninstagram.com/v/t51.2885-19/71533411_449636125903525_7464596574253875200_n.jpg?stp=dst-jpg_s320x320&_nc_ht=scontent-ssn1-1.cdninstagram.com&_nc_cat=1&_nc_ohc=46Hei6zgefcAX_ZYID0&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfBDTYWtogBWVxTSXTuu1-SZpHe4C9nrPXByBa98E7ljmQ&oe=645B8991&_nc_sid=8fd12b");
        account.setAccountImages(accountImage);

        //        given(getAccountUseCase.getAccount(1L)).willReturn(account);
    }


    @Test
    @DisplayName("계정 조회")
    void getAccountTest() throws Exception {
        mockMvc.perform(get("/account/{accountId}", 1L)).andDo(AccountControllerDocs.getAccountDetail()).andDo(print());
    }
}
