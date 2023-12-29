package com.joseph.repository;

import com.joseph.entity.Article;
import com.joseph.entity.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("articleRepository")
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	 List<Article> findByLibelleContainingIgnoreCase(String libelle);


}

