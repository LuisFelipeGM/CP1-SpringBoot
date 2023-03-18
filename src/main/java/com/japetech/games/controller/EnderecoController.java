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
@CrossOrigin(origins = "*", maxAge = 3600)
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
        BeanUtils.copyProperties(enderecoDto, enderecoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoModel> getGameById(@PathVariable Long id){
        Optional<EnderecoModel> optionalEndereco = Optional.ofNullable(enderecoService.findById(id));

        if(optionalEndereco.isPresent()){
            return ResponseEntity.ok(optionalEndereco.get());
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
