package org.sopt.domain.member.dto.response.article;

import org.sopt.domain.member.entity.Article;

public record ArticleResponse(
        long articleId,
        String tag,
        String title,
        String content,
        long userId,
        String userName
) {
    public static ArticleResponse of(Article article) {
        return new ArticleResponse(
                article.getId(),
                article.getTag().getValue(),
                article.getTitle(),
                article.getContent(),
                article.getMember().getId(),
                article.getMember().getName()
        );
    }
}
