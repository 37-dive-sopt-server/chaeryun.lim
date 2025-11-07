package org.sopt.domain.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.domain.member.dto.request.article.CreateArticleRequest;
import org.sopt.global.entity.BaseTimeEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tag tag;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, updatable = false)
    private Member member;

    @Builder
    public Article(Tag tag, String title, String content, Member member) {
        this.tag = tag;
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public static Article create(CreateArticleRequest request, Member member) {
        return Article.builder()
                .title(request.title())
                .content(request.content())
                .member(member)
                .tag(request.tag())
                .build();
    }

    public void assignMember(Member member) {
        this.member = member;
    }
}

