package org.sopt.domain.member.dto.response.member;

import java.util.List;

public record MemberListResponse(
        List<MemberResponse> memberResponses
) {
}
