package com.quatropatas.adocao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.aot.generate.Generated;

@Getter
@Setter
@Entity
@Table(name = "TbAnimal")
public class AnimalEntity {

    @Id
    //@SequenceGenerator(name = "ANIMAL_ID", sequenceName = "ANIMAL_ID_SQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IdAnimal")
    private Integer id;
    @Column(name="especie")
    private String especie;
    @Column(name="raca")
    private String raca;
    @Column(name="idade")
    private Integer idade;
    @Column(name="cor")
    private String cor;
    @Column(name="descricao")
    private String descricao;

}
