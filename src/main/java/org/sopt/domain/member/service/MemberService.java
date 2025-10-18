package org.sopt.domain.member.service;

import org.sopt.domain.member.dto.request.CreateMemberRequest;
import org.sopt.domain.member.dto.response.CreateMemberResponse;
import org.sopt.domain.member.dto.response.MemberResponse;

import java.util.List;

public interface MemberService {

    // 가입
    CreateMemberResponse join(final CreateMemberRequest createMemberRequest);

    // memberId로 사용자 조회
    MemberResponse findOne(final Long memberId);

    // 모든 사용자 조회
    List<MemberResponse> findAllMembers();

    // 회원 삭제
    void deleteMember(final Long memberId);

    // 종료 전 회원 전체 저장
    void saveFile();
}
