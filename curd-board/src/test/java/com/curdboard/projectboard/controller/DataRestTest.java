package com.curdboard.projectboard.controller;

import org.hibernate.persister.entity.AbstractEntityPersister;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@Disabled("Spring Data Rest 통합테스트는 불필요하므로 제외시킴")
@DisplayName("Data Rest api Test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {
    private final MockMvc mvc;

    public DataRestTest(@Autowired  MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void givenNoting_whenRequestingArticles_thenReturnArticleJsonResponse() throws Exception {
        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articles/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글 -> 댓글 조회")
    @Test
    void givenNoting_whenRequestingArticleCommentFromArticle_thenReturnArticleCommentsJsonResponse() throws Exception {
        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articles/1/articleComments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }
    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void givenNoting_whenRequestingArticleComment_thenReturnArticleCommentsJsonResponse() throws Exception {
        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articleComments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }
    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void givenNoting_whenRequestingArticleComment_thenReturnArticleCommentJsonResponse() throws Exception {
        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articleComments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }

}
