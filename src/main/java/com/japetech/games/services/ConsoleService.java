package com.japetech.games.services;

import com.japetech.games.models.ConsoleModel;
import com.japetech.games.repositories.ConsoleRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService extends MyService<ConsoleModel, Long>{

    public ConsoleService(ConsoleRepository repository){
        super(repository);
    }
}
