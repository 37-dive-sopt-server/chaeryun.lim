package org.sopt.domain.member.dto.request.article;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.sopt.domain.member.entity.article.Tag;

public record CreateArticleRequest(
        @NotNull(message = "작성자 ID는 필수입니다.")
        Long userId,

        @NotNull(message = "태그는 필수입니다.")
        Tag tag,

        @NotBlank(message = "제목은 비워둘 수 없습니다.")
        @Size(max = 100, message = "제목은 100자를 넘을 수 없습니다.")
        String title,

        @NotBlank(message = "내용은 비워둘 수 없습니다.")
        String content
) {
}
