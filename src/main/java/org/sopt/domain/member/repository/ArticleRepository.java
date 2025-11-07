package org.sopt.domain.member.repository;

import org.sopt.domain.member.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findById(final long id);
    Article save(Article article);
    Optional<Article> findByTitle(String title);
}
