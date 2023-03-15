package com.japetech.games.services;

import com.japetech.games.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService extends MyService<GameModel, Long>{

    GameService(JpaRepository<GameModel, Long> repository){
        super(repository);
    }
}
