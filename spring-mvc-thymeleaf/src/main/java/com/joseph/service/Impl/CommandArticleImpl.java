package com.joseph.service.Impl;

import com.joseph.entity.CommandArticle;
import com.joseph.repository.CommandArticleRepository;
import com.joseph.service.CommandArticleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class CommandArticleImpl implements CommandArticleService {

	 @Autowired
	    private CommandArticleRepository commandArticleRepository;

	    @Override
	    @Transactional
	    public List<CommandArticle> getCommandArticles() {
	        return commandArticleRepository.findAll();
	    }

	    @Override
	    @Transactional
	    public void saveCommandArticle(CommandArticle theCommandArticle) {
	        commandArticleRepository.save(theCommandArticle);
	    }

	    @Override
	    @Transactional
	    public CommandArticle getCommandArticle(int id) throws NullPointerException {
	        return commandArticleRepository.findById(id).orElseThrow(
	                () -> new NullPointerException("CommandArticle with ID = ${id} is not found"));
	    }

	    @Override
	    @Transactional
	    public void deleteCommandArticle(int theId) {
	        commandArticleRepository.deleteById(theId);
	    }

		@Override
		public List<CommandArticle> searchCommandArticles(String keyword) {
			keyword = "%" + keyword + "%";	
			    return null;//commandArticleRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, keyword);
		}
	}
