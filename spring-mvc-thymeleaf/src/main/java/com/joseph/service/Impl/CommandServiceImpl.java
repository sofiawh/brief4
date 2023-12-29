package com.joseph.service.Impl;

import com.joseph.entity.Command;
import com.joseph.entity.Command;
import com.joseph.repository.CommandRepository;
import com.joseph.service.CommandService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommandServiceImpl implements CommandService {
	@Autowired
    private CommandRepository commandRepository;

    @Override
    @Transactional
    public List<Command> getCommands() {
        return commandRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCommand(Command theCommand) {   	   	
    	
        commandRepository.save(theCommand);
    	// commandRepository.saveCommandWithParameters(theCommand.getId(), theCommand.getCustomer(), theCommand.getState());
    	   
    }

    @Override
    @Transactional
    public Command getCommand(int id) throws NullPointerException {
        return commandRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Command with ID = ${id} is not found"));
    }

    @Override
    @Transactional
    public void deleteCommand(int theId) {
        commandRepository.deleteById(theId);
    }
/*
	@Override
	public List<Command> searchCommands(String keyword) {
		keyword = "%" + keyword + "%";	
		System.out.println("AAAAAAAAAAAAAAAAAAAAA******");
	    System.out.println("list searchcommand---***"+commandRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, keyword).size());
	    return commandRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, keyword);
	}*/
}
