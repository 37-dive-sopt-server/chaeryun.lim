package org.sopt.domain.member.entity;

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
}
