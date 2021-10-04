package org.diegosilva.newAppBlog.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Classe DTO modelo para Logar e Alter usuario - Para loguin: necessario apenas
 * email e senha como atributos; - Para Alterar: necessario o id para alterar
 * nome e senha; - nota: email é um atributo que não pode ser alterado
 *
 * @since 1.5
 * @author Turma 28
 *
 */
public class UserLogin {

    @Id
    @Getter
    @Setter
    private Long id;

    @NotBlank
    @Getter @Setter
    private String nome;

    @NotBlank(message = "Necessario Email")
    @Email(message = "Necessario Email")
    @Getter
    @Setter
    private String email;



    @Size(min = 5, max = 100, message = "Necessario min 5 caracteres")
    @Getter
    @Setter
    private String senha;

    @Getter
    @Setter
    private String token;



}