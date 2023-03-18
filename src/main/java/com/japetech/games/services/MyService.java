package com.japetech.games.services;

import com.japetech.games.interfaces.IMyService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MyService<T,Id> implements IMyService<T, Id> {

    final JpaRepository<T, Id> repository;

    MyService(JpaRepository<T, Id> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Transactional
    public T save(T object){
        return repository.save(object);
    }

    @Transactional
    public void deleteById(@NotNull Id id){
        Optional<T> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.deleteById(id);
        }else{
            throw new NoSuchElementException("Registro não encontrado com o ID fornecido: " + id);
        }
    }

    @Transactional
    public T findById(@NotNull Id id){
        Optional<T> optional = repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new NoSuchElementException("Registro não encontrado com o ID fornecido: " + id);
        }
    }
}
