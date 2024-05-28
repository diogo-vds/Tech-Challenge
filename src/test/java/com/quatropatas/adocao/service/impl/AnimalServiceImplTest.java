package com.quatropatas.adocao.service.impl;

import com.quatropatas.adocao.dto.AnimalDTO;
import com.quatropatas.adocao.entity.AnimalEntity;
import com.quatropatas.adocao.repository.IAnimalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceImplTest {

    @Mock
    IAnimalRepository repository;
    @InjectMocks
    AnimalServiceImpl service;

    @Test
    public void testListar() {
        when(repository.findAll()).thenReturn(mockListAnimal());
        Assertions.assertFalse(service.listar().isEmpty());
    }
    @Test
    public void testBuscar(){
        when(repository.findById(any())).thenReturn(Optional.of(mockAnimal()));
        AnimalDTO dto = service.buscar(1);
        Assertions.assertNotNull(dto);
    }
    @Test
    public void cadastrar(){
        when(repository.save(any(AnimalEntity.class))).thenReturn(new AnimalEntity());
        service.cadastrar(this.mockAnimalDto());
        verify(repository).save(any(AnimalEntity.class));
    }
    @Test
    public void alterar(){
        when(repository.save(any(AnimalEntity.class))).thenReturn(new AnimalEntity());
        service.alterar(this.mockAnimalDto());
        verify(repository).save(any(AnimalEntity.class));
    }
    @Test
    public void excluir(){
        doNothing().when(repository).deleteById(any());
        service.excluir(any());
        verify(repository).deleteById(any());
    }

    private List<AnimalEntity> mockListAnimal(){
        List<AnimalEntity> animais = new ArrayList<>();
        for(int i = 0; i<5; i++) {
            AnimalEntity animal = new AnimalEntity();
            animal.setId(i);
            animal.setIdade(i);
            animal.setRaca("raca"+i);
            animal.setCor("cor"+i);
            animal.setDescricao("descricao"+i);
            animais.add(animal);
        }
        return animais;
    }

    private AnimalEntity mockAnimal(){
        AnimalEntity animal = new AnimalEntity();
        animal.setId(1);
        animal.setIdade(1);
        animal.setRaca("raca");
        animal.setCor("cor");
        animal.setDescricao("descricao");
        return animal;
    }

    private AnimalDTO mockAnimalDto(){
        AnimalDTO animal = new AnimalDTO();
        animal.setId(1);
        animal.setIdade(1);
        animal.setRaca("raca");
        animal.setCor("cor");
        animal.setDescricao("descricao");
        return animal;
    }
}
