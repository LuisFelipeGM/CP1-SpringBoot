package com.japetech.games.controller;


import com.japetech.games.gamesDtos.ConsoleDto;
import com.japetech.games.models.ConsoleModel;
import com.japetech.games.services.ConsoleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/console")
public class ConsoleController {

    final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService){
        this.consoleService = consoleService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(){
        return ResponseEntity.status(HttpStatus.OK).body(consoleService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveGame(@Valid @RequestBody ConsoleDto consoleDto){

        ConsoleModel consoleModel = new ConsoleModel();
        BeanUtils.copyProperties(consoleDto, consoleModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(consoleService.save(consoleModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsoleModel> getGameById(@PathVariable Long id){
        Optional<ConsoleModel> optionalGame = Optional.ofNullable(consoleService.findById(id));

        if(optionalGame.isPresent()){
            return ResponseEntity.ok(optionalGame.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        consoleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
