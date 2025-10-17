package org.sopt.domain.member.service;

import org.sopt.domain.member.dto.request.CreateMemberRequest;
import org.sopt.domain.member.dto.response.CreateMemberResponse;
import org.sopt.domain.member.dto.response.MemberResponse;
import org.sopt.domain.member.entity.Gender;
import org.sopt.domain.member.entity.Member;
import org.sopt.domain.member.repository.MemberRepository;
import org.sopt.domain.member.repository.MemoryMemberRepository;
import org.sopt.global.exception.ErrorCode;
import org.sopt.global.exception.handler.MemberException;
import org.sopt.global.util.DateUtil;
import org.sopt.global.util.MemberValidator;

import java.time.LocalDate;
import java.util.List;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private static long sequence = 1L;

    public MemberServiceImpl(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 사용자 저장
    @Override
    public CreateMemberResponse join(CreateMemberRequest createMemberRequest) {

        // 1. DTO 형식 검증
        MemberValidator.validate(createMemberRequest);

        // 2. 생일 LocalDate로 변환
        LocalDate date = DateUtil.string2Date(createMemberRequest.birthDay());

        // 3. 중복 검증
        if (isValidEmail(createMemberRequest.email())){
            throw new MemberException(ErrorCode.EXIST_EMAIL);
        }

        // 4. Gender 검사
        Gender from = Gender.from(createMemberRequest.gender());

        Member member = new Member.
                Builder(sequence++, createMemberRequest.name())
                .birthDay(date)
                .email(createMemberRequest.email())
                .gender(from)
                .build();

        Member save = memberRepository.save(member);

        return new CreateMemberResponse(save.getId());
    }

    // 사용자 조회
    @Override
    public MemberResponse findOne(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(ErrorCode.NOT_FOUND_MEMBER));

        return MemberResponse.of(member);
    }

    // 전체 사용자 조회
    @Override
    public List<MemberResponse> findAllMembers() {

        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::of)
                .toList();
    }

    // 사용자 삭제
    @Override
    public void deleteMember(Long memberId) {
        Member byId = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(ErrorCode.NOT_FOUND_MEMBER));

        memberRepository.deleteById(byId.getId());
    }

    // 이메일 중복확인 (있으면 true)
    private boolean isValidEmail(String email){
        return memberRepository.existMemberByEmail(email).isPresent();
    }
}
