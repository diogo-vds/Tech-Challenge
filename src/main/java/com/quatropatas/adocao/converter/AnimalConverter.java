package com.quatropatas.adocao.converter;

import com.quatropatas.adocao.dto.AnimalDTO;
import com.quatropatas.adocao.entity.AnimalEntity;

import java.util.ArrayList;
import java.util.List;

public class AnimalConverter {

    public static AnimalEntity toEntity(AnimalDTO dto){
        AnimalEntity entity = new AnimalEntity();
        entity.setRaca(dto.getRaca());
        entity.setId(dto.getId());
        entity.setEspecie(dto.getEspecie());
        entity.setCor(dto.getCor());
        entity.setDescricao(dto.getDescricao());
        entity.setIdade(dto.getIdade());
        return entity;
    }

    public static List<AnimalEntity> toListEntity(List<AnimalDTO> dtos){
        List<AnimalEntity> entities = new ArrayList<>();
        for(AnimalDTO dto : dtos){
            entities.add(toEntity(dto));
        }
        return entities;
    }

    public static AnimalDTO toDto(AnimalEntity entity){
        AnimalDTO dto = new AnimalDTO();
        if(entity != null) {
            dto.setCor(entity.getCor());
            dto.setDescricao(entity.getDescricao());
            dto.setId(entity.getId());
            dto.setRaca(entity.getRaca());
            dto.setIdade(entity.getIdade());
            dto.setEspecie(entity.getEspecie());
        }
        return dto;
    }

    public static List<AnimalDTO> toListDto(List<AnimalEntity> entities){
        List<AnimalDTO> dtos = new ArrayList<>();
        if(entities != null){
            entities.forEach(entity -> dtos.add(toDto(entity)));
        }
        return dtos;
    }
}
