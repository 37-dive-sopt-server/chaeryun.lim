package org.sopt.domain.member.controller;

import org.sopt.domain.member.dto.request.CreateMemberRequest;
import org.sopt.domain.member.dto.response.CreateMemberResponse;
import org.sopt.domain.member.dto.response.MemberResponse;
import org.sopt.domain.member.service.MemberService;

import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    // 사용자 생성
    public CreateMemberResponse createMember(final CreateMemberRequest createMemberRequest) {
        return memberService.join(createMemberRequest);
    }

    // 식별자로 사용자 조회
    public MemberResponse findMemberById(final Long id) {
        return memberService.findOne(id);
    }

    // 전체 사용자 조회
    public List<MemberResponse> getAllMembers() {
        return memberService.findAllMembers();
    }

    // 사용자 삭제
    public boolean deleteMember(final Long id){
        memberService.deleteMember(id);
        return true;
    }

    // 종료 전 파일 저장
    public void saveFile(){
        memberService.saveFile();
    }
}
