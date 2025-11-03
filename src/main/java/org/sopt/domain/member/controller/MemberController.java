package org.sopt.domain.member.controller;

import org.sopt.domain.member.dto.request.CreateMemberRequest;
import org.sopt.domain.member.dto.response.CreateMemberResponse;
import org.sopt.domain.member.dto.response.MemberListResponse;
import org.sopt.domain.member.dto.response.MemberResponse;
import org.sopt.domain.member.service.MemberService;
import org.sopt.global.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    // 사용자 생성
    @PostMapping
    public ResponseEntity<ApiResponse<CreateMemberResponse>> createMember(@RequestBody final CreateMemberRequest createMemberRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.created(
                        "멤버 등록이 성공하였습니다.",
                        memberService.join(createMemberRequest)
                )
        );
    }

    // 식별자로 사용자 조회
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<MemberResponse>> findMemberById(@PathVariable final Long userId) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "멤버 조회가 성공하였습니다.",
                        memberService.findOne(userId)
                )
        );
    }

    // 전체 사용자 조회
    @GetMapping
    public ResponseEntity<ApiResponse<MemberListResponse>> getAllMembers() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "멤버 목록 조회 성공",
                        memberService.findAllMembers()
                )
        );
    }

    // 사용자 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteMember(@PathVariable final Long userId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                ApiResponse.ok("", null)
        );
    }

}
