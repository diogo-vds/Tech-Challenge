package com.quatropatas.adocao.repository;

import com.quatropatas.adocao.entity.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalRepository  extends JpaRepository<AnimalEntity, Integer> {

}
