package com.japetech.games.repositories;

import com.japetech.games.models.ConsoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<ConsoleModel, Long> {
}
