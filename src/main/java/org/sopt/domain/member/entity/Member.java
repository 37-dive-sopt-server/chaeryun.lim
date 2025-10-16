package org.sopt.domain.member.entity;

import java.time.LocalDate;

public class Member {
    private Long id;
    private String name;
    private LocalDate birthDay; // 생년월일
    private String email;       // 이메일
    private Gender gender;      // 성별

    private Member(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.birthDay = builder.birthDay;
        this.email = builder.email;
        this.gender = builder.gender;
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

    public static class Builder {
        private Long id;
        private String name;
        private LocalDate birthDay;
        private String email;
        private Gender gender;

        // 필수 파라미터는 빌더 생성자로 받기
        public Builder(Long id, String name){
            this.id = id;
            this.name = name;
        }

        // ===그 외 선택 파라미터들=== //

        public Builder birthDay(LocalDate birthDay){
            this.birthDay = birthDay;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder gender(Gender gender){
            this.gender = gender;
            return this;
        }

        // 빌드
        public Member build(){
            return new Member(this);
        }
    }

}
