package com.joseph.repository;

import com.joseph.entity.CommandArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("commandArticleRepository")
public interface CommandArticleRepository extends JpaRepository<CommandArticle, Integer> {
}
