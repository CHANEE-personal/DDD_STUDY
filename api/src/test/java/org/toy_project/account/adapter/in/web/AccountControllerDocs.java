package org.toy_project.account.adapter.in.web;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import static org.springframework.restdocs.payload.PayloadDocumentation.beneathPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

public class AccountControllerDocs {

    public static RestDocumentationResultHandler getAccountDetail() {
        return document("get-account-detail", pathParameters(parameterWithName("accountId").description("계정 ID")),
                getResponseFieldsSnippet(), getAccountImageFieldsSnippet());
    }


    private static ResponseFieldsSnippet getResponseFieldsSnippet() {
        return responseFields(beneathPath("account").withSubsectionId("account-detail"),
                fieldWithPath("id").description("계정 idx"), fieldWithPath("accountName").description("계정명"),
                fieldWithPath("hashTag").description("해시태그"), fieldWithPath("youtubeUrl").description("유튜브"),
                fieldWithPath("postCount").description("게시글"), fieldWithPath("followCount").description("팔로우수"),
                fieldWithPath("followerCount").description("팔로워"),
                subsectionWithPath("accountImage").description("<<account-image, 계정 이미지>>"));
    }


    private static ResponseFieldsSnippet getAccountImageFieldsSnippet() {
        return responseFields(beneathPath("account.accountImage").withSubsectionId("account-image"),
                fieldWithPath("id").description("이미지 idx"), fieldWithPath("type").description("계정 Type"),
                fieldWithPath("imageUrl").description("이미지URL"));
    }
}
