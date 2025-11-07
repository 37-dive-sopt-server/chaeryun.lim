package org.sopt.domain.member.service.article;

import org.sopt.domain.member.dto.request.article.CreateArticleRequest;
import org.sopt.domain.member.dto.response.article.ArticleListResponse;
import org.sopt.domain.member.dto.response.article.ArticleResponse;

public interface ArticleService {

    ArticleResponse getArticle(long articleId);
    ArticleResponse createArticle(CreateArticleRequest request);
    ArticleListResponse getArticles();
}
