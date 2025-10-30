package org.sopt.domain.member.controller;

import org.sopt.domain.member.dto.request.CreateMemberRequest;
import org.sopt.domain.member.dto.response.CreateMemberResponse;
import org.sopt.domain.member.dto.response.MemberResponse;
import org.sopt.domain.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    // 사용자 생성
    @PostMapping
    public CreateMemberResponse createMember(@RequestBody final CreateMemberRequest createMemberRequest) {
        return memberService.join(createMemberRequest);
    }

    // 식별자로 사용자 조회
    @GetMapping("/{userId}")
    public MemberResponse findMemberById(@PathVariable final Long userId) {
        return memberService.findOne(userId);
    }

    // 전체 사용자 조회
    @GetMapping
    public List<MemberResponse> getAllMembers() {
        return memberService.findAllMembers();
    }

    // 사용자 삭제
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable final Long userId){
        memberService.deleteMember(userId);
    }

    // 종료 전 파일 저장
    public void saveFile(){
        memberService.saveFile();
    }
}
