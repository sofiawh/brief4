package com.joseph.service.Impl;

import com.joseph.entity.Article;
import com.joseph.entity.Article;
import com.joseph.repository.ArticleRepository;
import com.joseph.service.ArticleService;
import com.joseph.service.ArticleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @Transactional
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @Override
    @Transactional
    public void saveArticle(Article theArticle) {
        articleRepository.save(theArticle);
    }

    @Override
    @Transactional
    public Article getArticle(int id) throws NullPointerException {
        return articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Article with ID = ${id} is not found"));
    }

    @Override
    @Transactional
    public void deleteArticle(int theId) {
        articleRepository.deleteById(theId);
    }

	@Override
	public List<Article> searchArticles(String keyword) {
		keyword = "%" + keyword + "%";	
		    return articleRepository.findByLibelleContainingIgnoreCase(keyword);
	}
}
