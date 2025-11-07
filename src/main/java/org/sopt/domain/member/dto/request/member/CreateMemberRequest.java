package org.sopt.domain.member.dto.request.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.sopt.domain.member.entity.member.Gender;

import java.time.LocalDate;

public record CreateMemberRequest(
        @NotBlank(message = "이름은 비워둘 수 없습니다.")
        String name,

        @NotNull(message = "생년월일은 비워둘 수 없습니다.")
        LocalDate birthDay,

        @NotBlank(message = "이메일은 비워둘 수 없습니다.")
        @Email(message = "유효한 이메일 형식이어야 합니다.")
        String email,

        @NotNull(message = "성별은 필수입니다.")
        Gender gender
) {
}
