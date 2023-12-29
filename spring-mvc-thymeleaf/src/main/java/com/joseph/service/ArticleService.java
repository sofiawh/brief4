package com.joseph.service;

import java.util.List;

import com.joseph.entity.Article;

public interface ArticleService {
	
	public List<Article> getArticles();

    public void saveArticle(Article theArticle);

    public Article getArticle(int theId);

    public void deleteArticle(int theId);
    
    public List<Article> searchArticles(String keyword);

}
