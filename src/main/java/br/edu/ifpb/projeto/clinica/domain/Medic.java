package br.edu.ifpb.projeto.clinica.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medic {
    @EqualsAndHashCode.Include
    private String id;

    @Field("NOME")
    private String name;

    @Field("SEXO")
    private String sex;

    @Field("CONTATO")
    private String contact;

    @Field("ESPECIALIDADE")
    private String specialty;

    @Field("DISPONIBILIDADE")
    private boolean disponibility;
}
