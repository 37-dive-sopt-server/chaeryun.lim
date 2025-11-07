package org.sopt.domain.member.dto.response.article;

import java.util.List;

public record ArticleListResponse(
        List<ArticleResponse> articles
) {
}
