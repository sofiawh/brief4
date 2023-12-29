package com.joseph.service;

import java.util.List;

import com.joseph.entity.Command;
import com.joseph.entity.Command;

public interface CommandService {

	
    public List<Command> getCommands();

    public void saveCommand(Command theCommand);

    public Command getCommand(int theId);

    public void deleteCommand(int theId);
    
  //  public List<Command> searchCommands(String keyword);
}
