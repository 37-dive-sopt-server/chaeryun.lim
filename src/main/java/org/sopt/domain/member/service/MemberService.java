package org.sopt.domain.member.service;

import org.sopt.domain.member.dto.request.CreateMemberRequest;
import org.sopt.domain.member.dto.response.CreateMemberResponse;
import org.sopt.domain.member.dto.response.MemberResponse;
import org.sopt.domain.member.entity.Member;

import java.util.List;

public interface MemberService {

    // 가입
    CreateMemberResponse join(CreateMemberRequest createMemberRequest);

    // memberId로 사용자 조회
    MemberResponse findOne(Long memberId);

    // 모든 사용자 조회
    List<MemberResponse> findAllMembers();

    // 회원 삭제
    void deleteMember(Long memberId);
}
