package com.quatropatas.adocao.service;

import com.quatropatas.adocao.dto.AnimalDTO;

import java.util.List;

public interface AnimalService {

    List<AnimalDTO> listar();
    AnimalDTO buscar(Integer id);
    void cadastrar(AnimalDTO animal);
    void alterar(AnimalDTO animal);
    void excluir(Integer id);

}
