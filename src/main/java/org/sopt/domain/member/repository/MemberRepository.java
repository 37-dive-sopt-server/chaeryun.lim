package org.sopt.domain.member.repository;

import org.sopt.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 사용자 저장
    Member save(Member member);

    // 식별자로 사용자 조회
    Optional<Member> findById(Long id);

    // 사용자 전체 조회
    List<Member> findAll();

    // 사용자 삭제
    void deleteById(Long id);

    // 이메일 중복검증
    Optional<Member> existMemberByEmail(String email);
}
