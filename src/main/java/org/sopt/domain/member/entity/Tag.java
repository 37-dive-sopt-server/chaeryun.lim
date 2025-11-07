package org.sopt.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Tag {
    CS("CS"), DB("DB"), SPRING("SPRING"), ETC("ETC");

    private final String value;
}
