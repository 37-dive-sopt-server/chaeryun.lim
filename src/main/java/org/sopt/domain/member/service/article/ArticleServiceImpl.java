package org.sopt.domain.member.service.article;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.member.dto.request.article.CreateArticleRequest;
import org.sopt.domain.member.dto.response.article.ArticleListResponse;
import org.sopt.domain.member.dto.response.article.ArticleResponse;
import org.sopt.domain.member.entity.article.Article;
import org.sopt.domain.member.entity.member.Member;
import org.sopt.domain.member.repository.ArticleRepository;
import org.sopt.domain.member.service.member.MemberService;
import org.sopt.global.exception.ErrorCode;
import org.sopt.global.exception.handler.ArticleException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberService memberService;

    @Override
    public ArticleResponse getArticle(long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleException(ErrorCode.NOT_FOUND_ARTICLE));

        return ArticleResponse.of(article);
    }

    @Override
    @Transactional
    public ArticleResponse createArticle(CreateArticleRequest request) {
        if (checkTitle(request.title())) {
            throw new ArticleException(ErrorCode.ARTICLE_DUPLICATE_TITLE);
        }

        Member member = memberService.findMemberById(request.userId());

        Article article = articleRepository.save(Article.create(request, member));
        return ArticleResponse.of(article);
    }

    @Override
    public ArticleListResponse getArticles() {
        List<ArticleResponse> list = articleRepository.findAll().stream()
                .map(ArticleResponse::of)
                .toList();

        return new ArticleListResponse(list);
    }

    private boolean checkTitle(String title){
        return articleRepository.findByTitle(title)
                .isPresent();
    }
}
