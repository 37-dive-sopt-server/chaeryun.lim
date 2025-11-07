package org.sopt.domain.member.dto.response.member;

import org.sopt.domain.member.entity.Member;
import org.sopt.global.util.DateUtil;

public record MemberResponse(
        Long id,
        String name,
        String birthDay,
        String email,
        String gender
) {

    public static MemberResponse of(Member member){
        return new MemberResponse(member.getId(),
                member.getName(),
                DateUtil.Date2String(member.getBirthDay()),
                member.getEmail(),
                member.getGender().getDescription());
    }
}
