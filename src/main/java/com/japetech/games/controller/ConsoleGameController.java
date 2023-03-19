package com.japetech.games.controller;

import com.japetech.games.gamesDtos.ConsoleGameDto;
import com.japetech.games.models.ConsoleGameModel;
import com.japetech.games.services.ConsoleGameService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/consolegame")
public class ConsoleGameController {

    final ConsoleGameService consoleGameService;

    public ConsoleGameController(ConsoleGameService consoleGameService){
        this.consoleGameService = consoleGameService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(){
        return ResponseEntity.status(HttpStatus.OK).body(consoleGameService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveGame(@Valid @RequestBody ConsoleGameDto consoleGameDto){

        ConsoleGameModel consoleGameModel = new ConsoleGameModel();
        BeanUtils.copyProperties(consoleGameDto, consoleGameModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(consoleGameService.save(consoleGameModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsoleGameModel> getGameById(@PathVariable Long id){
        Optional<ConsoleGameModel> optionalGame = Optional.ofNullable(consoleGameService.findById(id));

        if(optionalGame.isPresent()){
            return ResponseEntity.ok(optionalGame.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        consoleGameService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
