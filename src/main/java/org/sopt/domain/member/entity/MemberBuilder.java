package org.sopt.domain.member.entity;

import java.time.LocalDate;

/**
 * Member 빌더 클래스
 */
public class MemberBuilder {
    private Long id;
    private String name;
    private LocalDate birthDay;
    private String email;
    private Gender gender;

    public MemberBuilder id(Long id){
        this.id = id;
        return this;
    }

    public MemberBuilder name(String name){
        this.name = name;
        return this;
    }

    public MemberBuilder birthDay(LocalDate birthDay){
        this.birthDay = birthDay;
        return this;
    }

    public MemberBuilder email(String email){
        this.email = email;
        return this;
    }

    // 빌드
    public Member build(){
        return new Member(id, name, birthDay, email, gender);
    }
}
