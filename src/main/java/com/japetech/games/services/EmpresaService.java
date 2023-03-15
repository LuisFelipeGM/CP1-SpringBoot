package com.japetech.games.services;

import com.japetech.games.models.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService extends MyService<EmpresaModel, Long>{

    EmpresaService(JpaRepository<EmpresaModel, Long> repository) {
        super(repository);
    }
}
