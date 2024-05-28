package com.quatropatas.adocao.controller;

import com.quatropatas.adocao.dto.AnimalDTO;
import com.quatropatas.adocao.service.AnimalService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping
public class CadastroController {

    @Autowired
    AnimalService service;

    @GetMapping(path = "/listar", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AnimalDTO>> listar(){
        List<AnimalDTO> animais = service.listar();
        if(animais.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(animais, HttpStatus.OK);
    }

    @GetMapping(path = "/buscar/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AnimalDTO> buscar(@PathVariable Integer id){
        AnimalDTO animal = service.buscar(id);
        if(animal.getId() == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @PostMapping(path = "/cadastrar", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody AnimalDTO animal){
        service.cadastrar(animal);
    }

    @PutMapping(path = "/alterar", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestBody AnimalDTO animal){
        service.alterar(animal);
    }

    @DeleteMapping(path = "/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id){
        service.excluir(id);
    }

}
