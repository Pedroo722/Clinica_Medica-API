package br.edu.ifpb.projeto.clinica.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Patient implements Serializable {
    @EqualsAndHashCode.Include
    private String id;

    @Field("NAME")
    private String name;

    @Field("SEXO")
    private String sex;

    @Field("TELEFONE")
    private String phone;

    @Field("EMAIL")
    private String email;

    @Field("ENDERECO")
    private String address;

    @Field("DATA_NASCIMENTO")
    private LocalDate birthDate;
}