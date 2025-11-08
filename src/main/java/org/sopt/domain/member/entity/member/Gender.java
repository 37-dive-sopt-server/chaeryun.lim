package org.sopt.domain.member.entity.member;

import java.util.Arrays;

public enum Gender {
    MALE("남성"),
    FEMALE("여성"),
    OTHER("기타");

    // 한글 설명
    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // 한글 -> Enum 변환용 메서드
    public static Gender from(String description){
        return Arrays.stream(values())
                .filter(gender -> gender.description.equals(description))
                .findFirst()
                .get();
        // 추후 예외처리
    }
}
