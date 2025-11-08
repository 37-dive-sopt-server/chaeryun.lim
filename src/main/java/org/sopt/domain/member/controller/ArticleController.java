package org.sopt.domain.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.domain.member.dto.request.article.CreateArticleRequest;
import org.sopt.domain.member.dto.response.article.ArticleListResponse;
import org.sopt.domain.member.dto.response.article.ArticleResponse;
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
    public ResponseEntity<ApiResponse<ArticleResponse>> createArticle(@Valid @RequestBody CreateArticleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.created(
                        "아티클 생성이 성공하였습니다.", articleService.createArticle(request)
                )
        );
    }

    @GetMapping
    public  ResponseEntity<ApiResponse<ArticleListResponse>> listArticles() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "아티클 전체 조회가 성공하였습니다.", articleService.getArticles()
                )
        );
    }
}
