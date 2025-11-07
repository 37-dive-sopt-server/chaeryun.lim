package org.sopt.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.member.dto.request.article.CreateArticleRequest;
import org.sopt.domain.member.dto.response.article.ArticleResponse;
import org.sopt.domain.member.entity.Article;
import org.sopt.domain.member.service.article.ArticleService;
import org.sopt.global.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ArticleResponse>> getArticle(@PathVariable long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "아티클 조회가 성공하였습니다.", articleService.getArticle(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ArticleResponse>> createArticle(@RequestBody CreateArticleRequest request) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                ApiResponse.created(
                        "아티클 생성이 성공하였습니다.", articleService.createArticle(request)
                )
        );
    }
}
