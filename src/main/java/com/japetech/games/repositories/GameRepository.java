package com.japetech.games.repositories;

import com.japetech.games.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository  extends JpaRepository<GameModel, Long> {
}
