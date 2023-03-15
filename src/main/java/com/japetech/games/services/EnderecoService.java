package com.japetech.games.services;

import com.japetech.games.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends MyService<EnderecoModel, Long>{

    EnderecoService(JpaRepository<EnderecoModel, Long> repository){
        super(repository);
    }
}
