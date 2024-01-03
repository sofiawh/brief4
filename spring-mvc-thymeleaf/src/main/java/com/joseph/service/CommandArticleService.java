package com.joseph.service;

import java.util.List;

import com.joseph.entity.CommandArticle;

public interface CommandArticleService {
	
	  public List<CommandArticle> getCommandArticles();

	    public void saveCommandArticle(CommandArticle theCommandArticle);

	    public CommandArticle getCommandArticle(int theId);

	    public void deleteCommandArticle(int theId);
	    
	    public List<CommandArticle> searchCommandArticles(String keyword);
}
