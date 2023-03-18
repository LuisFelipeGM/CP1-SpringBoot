package com.japetech.games.controller;

import com.japetech.games.gamesDtos.GameDto;
import com.japetech.games.models.GameModel;
import com.japetech.games.services.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {

    final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveGame(@Valid @RequestBody GameDto gameDto){

        GameModel gameModel = new GameModel();
        BeanUtils.copyProperties(gameDto, gameModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.save(gameModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameModel> getGameById(@PathVariable Long id){
        Optional<GameModel> optionalGame = Optional.ofNullable(gameService.findById(id));

        if(optionalGame.isPresent()){
            return ResponseEntity.ok(optionalGame.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        gameService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
