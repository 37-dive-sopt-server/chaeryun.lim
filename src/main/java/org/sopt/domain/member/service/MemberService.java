package org.sopt.domain.member.service;

import org.sopt.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    // 가입
    Long join(String name, String birthDay, String email, String gender);

    // memberId로 사용자 조회
    Optional<Member> findOne(Long memberId);

    // 모든 사용자 조회
    List<Member> findAllMembers();
}
