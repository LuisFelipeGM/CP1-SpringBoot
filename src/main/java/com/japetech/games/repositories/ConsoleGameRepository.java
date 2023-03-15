package com.japetech.games.repositories;

import com.japetech.games.models.ConsoleGameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleGameRepository extends JpaRepository<ConsoleGameModel, Long> {
}
