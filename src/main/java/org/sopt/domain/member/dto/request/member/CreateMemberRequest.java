package org.sopt.domain.member.dto.request.member;

public record CreateMemberRequest(
        String name,
        String birthDay,
        String email,
        String gender
) {
}
