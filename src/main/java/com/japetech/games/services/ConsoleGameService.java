package com.japetech.games.services;

import com.japetech.games.models.ConsoleGameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsoleGameService extends MyService<ConsoleGameModel, Long>{
    ConsoleGameService(JpaRepository<ConsoleGameModel, Long> repository){
        super(repository);
    }
}
