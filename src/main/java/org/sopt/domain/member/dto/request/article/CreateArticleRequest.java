package org.sopt.domain.member.dto.request.article;

import org.sopt.domain.member.entity.Tag;

public record CreateArticleRequest(

        long userId,
        Tag tag,
        String title,
        String content
) {

}
