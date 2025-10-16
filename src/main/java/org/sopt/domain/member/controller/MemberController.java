package org.sopt.domain.member.controller;

import org.sopt.domain.member.entity.Member;
import org.sopt.domain.member.service.MemberService;

import java.util.List;
import java.util.Optional;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 사용자 생성
    public Long createMember(String name, String birthDay, String email, String gender) {
        return memberService.join(name, birthDay, email, gender);
    }

    // 식별자로 사용자 조회
    public Optional<Member> findMemberById(Long id) {
        return memberService.findOne(id);
    }

    // 전체 사용자 조회
    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }

    // 사용자 삭제
    public boolean deleteMember(Long id){
        memberService.deleteMember(id);
        return true;
    }
}
