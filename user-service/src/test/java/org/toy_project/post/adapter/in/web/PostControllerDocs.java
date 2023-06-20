package org.toy_project.post.adapter.in.web;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import static org.springframework.restdocs.payload.PayloadDocumentation.beneathPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;

public class PostControllerDocs {

    public static RestDocumentationResultHandler getPostDetail() {
        return document("get-post-detail", pathParameters(parameterWithName("postId").description("게시글 ID")),
                getResponseFieldsSnippet(), getPostImageFieldsSnippet());
    }


    private static ResponseFieldsSnippet getResponseFieldsSnippet() {
        return responseFields(beneathPath("post").withSubsectionId("post-detail"),
                fieldWithPath("id").description("게시글 idx"), fieldWithPath("title").description("게시글 제목"),
                fieldWithPath("description").description("게시글 상세내용"), fieldWithPath("viewCount").description("조회수"),
                fieldWithPath("favoriteCount").description("좋아요수"), fieldWithPath("replyCount").description("댓글수"),
                fieldWithPath("parentIdx").description("부모 idx"), fieldWithPath("visible").description("노출 여부"),
                subsectionWithPath("postImages").description("<<post-image, 게시글 이미지>>"),
                subsectionWithPath("replies").description("<<post-reply, 게시글 댓글>>"));
    }


    private static ResponseFieldsSnippet getPostImageFieldsSnippet() {
        return responseFields(beneathPath("post.postImages").withSubsectionId("post-image"),
                fieldWithPath("id").description("이미지 idx"), fieldWithPath("name").description("이미지명"),
                fieldWithPath("url").description("이미지 url"), fieldWithPath("sortNo").description("정렬 순서"));
    }


    private static ResponseFieldsSnippet getPostReplyFieldsSnippet() {
        return responseFields(beneathPath("post.replies").withSubsectionId("post-reply"),
                fieldWithPath("id").description("게시글 idx"), fieldWithPath("title").description("게시글 제목"),
                fieldWithPath("description").description("게시글 상세내용"), fieldWithPath("viewCount").description("조회수"),
                fieldWithPath("favoriteCount").description("좋아요수"), fieldWithPath("replyCount").description("댓글수"),
                fieldWithPath("parentIdx").description("부모 idx"), fieldWithPath("visible").description("노출 여부"));
    }
}
