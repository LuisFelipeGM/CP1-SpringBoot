package com.japetech.games.controller;

import com.japetech.games.gamesDtos.EmpresaDto;
import com.japetech.games.models.EmpresaModel;
import com.japetech.games.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(){
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveGame(@Valid @RequestBody EmpresaDto empresaDto){

        EmpresaModel empresaModel = new EmpresaModel();
        BeanUtils.copyProperties(empresaModel, empresaDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresaModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaModel> getGameById(@PathVariable Long id){
        Optional<EmpresaModel> optionalGame = Optional.ofNullable(empresaService.findById(id));

        if(optionalGame.isPresent()){
            return ResponseEntity.ok(optionalGame.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        empresaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
