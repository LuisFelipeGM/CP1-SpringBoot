package com.japetech.games.controller;

import com.japetech.games.gamesDtos.EnderecoDto;
import com.japetech.games.models.EnderecoModel;
import com.japetech.games.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveGame(@Valid @RequestBody EnderecoDto enderecoDto){

        EnderecoModel enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(enderecoModel, enderecoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> getGameById(@PathVariable Long id){
        Optional<EnderecoModel> optionalGame = Optional.ofNullable(enderecoService.findById(id));

        if(optionalGame.isPresent()){
            return ResponseEntity.ok(optionalGame.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
