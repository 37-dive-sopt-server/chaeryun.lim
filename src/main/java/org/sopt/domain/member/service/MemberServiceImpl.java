package org.sopt.domain.member.service;

import org.sopt.domain.member.entity.Member;
import org.sopt.domain.member.entity.MemberBuilder;
import org.sopt.domain.member.repository.MemberRepository;
import org.sopt.domain.member.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private static long sequence = 1L;

    public MemberServiceImpl(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long join(String name) {

        Member member = new MemberBuilder()
                .id(sequence++)
                .name(name)
                .build();

        Member save = memberRepository.save(member);

        return save.getId();
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
}
