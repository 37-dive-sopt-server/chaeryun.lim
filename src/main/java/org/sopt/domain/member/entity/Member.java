package org.sopt.domain.member.entity;

import java.time.LocalDate;

public class Member {
    private Long id;
    private String name;
    private LocalDate birthDay; // 생년월일
    private String email;       // 이메일
    private Gender gender;      // 성별

    public Member(Long id, String name, LocalDate birthDay, String email, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.email = email;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }
}
