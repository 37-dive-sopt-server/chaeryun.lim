package org.sopt.domain.member.repository;

import org.sopt.domain.member.entity.Member;
import org.sopt.global.exception.ErrorCode;
import org.sopt.global.exception.handler.MemberException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();

    // 저장
    @Override
    public Member save(final Member member) {
        store.put(member.getId(), member);
        return member;
    }

    // 식별자로 사용자 조회
    @Override
    public Optional<Member> findById(final Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 사용자 전체 조회
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // 사용자 삭제
    @Override
    public void deleteById(final Long id) {
        if (!store.containsKey(id)) {
            throw new MemberException(ErrorCode.NOT_FOUND_MEMBER);
        }
        store.remove(id);
    }

    // 이메일 중복 검증
    @Override
    public Optional<Member> existMemberByEmail(final String email) {

        for (Member member : store.values()) {
            if (member.getEmail().equals(email)) {
                return Optional.of(member);
            }
        }

        return Optional.empty();
    }
}
