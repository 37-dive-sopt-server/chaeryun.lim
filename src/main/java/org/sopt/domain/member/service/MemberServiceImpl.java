package org.sopt.domain.member.service;

import org.sopt.domain.member.entity.Gender;
import org.sopt.domain.member.entity.Member;
import org.sopt.domain.member.repository.MemberRepository;
import org.sopt.domain.member.repository.MemoryMemberRepository;
import org.sopt.global.util.DateUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private static long sequence = 1L;

    public MemberServiceImpl(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 사용자 저장
    @Override
    public Long join(String name, String birthDay, String email, String gender) {

        // 1. 생일 LocalDate로 변환
        LocalDate date = DateUtil.string2Date(birthDay);

        // 2. 중복 검증
        if (isValidEmail(email)){
            // 예외처리
        }

        // 3. Gender 검사
        Gender from = Gender.from(gender);

        Member member = new Member.
                Builder(sequence++, name)
                .birthDay(date)
                .email(email)
                .gender(from)
                .build();

        Member save = memberRepository.save(member);

        return save.getId();
    }

    // 사용자 조회
    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 전체 사용자 조회
    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    // 이메일 중복확인 (있으면 true)
    private boolean isValidEmail(String email){
        return memberRepository.existMemberByEmail(email).isPresent();
    }
}
