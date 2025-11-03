package org.sopt.domain.member.entity;

import jakarta.persistence.*;
import org.sopt.global.exception.ErrorCode;
import org.sopt.global.exception.handler.MemberException;
import org.sopt.global.util.DateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDay; // 생년월일
    private String email;       // 이메일
    @Enumerated(EnumType.STRING)
    private Gender gender;      // 성별

    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

    public Member() {

    }

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

        // 리치 도메인을 향하여..
        public Builder birthDay(LocalDate birthDay){
            if (LocalDate.now().getYear() - birthDay.getYear() < 19){
                throw new MemberException(ErrorCode.AGE_RESTRICTION);
            }
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
