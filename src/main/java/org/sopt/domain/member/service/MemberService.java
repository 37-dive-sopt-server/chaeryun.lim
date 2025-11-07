package org.sopt.domain.member.service;

import org.sopt.domain.member.dto.request.member.CreateMemberRequest;
import org.sopt.domain.member.dto.response.member.CreateMemberResponse;
import org.sopt.domain.member.dto.response.member.MemberListResponse;
import org.sopt.domain.member.dto.response.member.MemberResponse;

public interface MemberService {

    // 가입
    CreateMemberResponse join(final CreateMemberRequest createMemberRequest);

    // memberId로 사용자 조회
    MemberResponse findOne(final Long memberId);

    // 모든 사용자 조회
    MemberListResponse findAllMembers();

    // 회원 삭제
    void deleteMember(final Long memberId);

}
