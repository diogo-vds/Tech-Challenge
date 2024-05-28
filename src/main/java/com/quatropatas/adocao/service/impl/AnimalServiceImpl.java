package com.quatropatas.adocao.service.impl;

import com.quatropatas.adocao.converter.AnimalConverter;
import com.quatropatas.adocao.dto.AnimalDTO;
import com.quatropatas.adocao.entity.AnimalEntity;
import com.quatropatas.adocao.repository.IAnimalRepository;
import com.quatropatas.adocao.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    //crie uma classe de teste

    @Autowired
    IAnimalRepository repository;

    @Override
    public List<AnimalDTO> listar() {
        return AnimalConverter.toListDto(repository.findAll());
    }

    @Override
    public AnimalDTO buscar(Integer id) {
        return AnimalConverter.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public void cadastrar(AnimalDTO animal) {
        repository.save(AnimalConverter.toEntity(animal));
    }

    @Override
    public void alterar(AnimalDTO animal) {
        Optional optional = repository.findById(animal.getId());
        if(optional.isPresent()){
            AnimalEntity entity = (AnimalEntity) optional.get();
            entity.setCor(animal.getCor());
            entity.setRaca(animal.getRaca());
            entity.setDescricao(animal.getDescricao());
            entity.setIdade(animal.getIdade());
            entity.setRaca(animal.getRaca());
            repository.saveAndFlush(entity);
        }
        AnimalEntity entity = AnimalConverter.toEntity(animal);
        repository.save(entity);
    }

    @Override
    public void excluir(Integer id) {
        repository.deleteById(id);
    }
}
