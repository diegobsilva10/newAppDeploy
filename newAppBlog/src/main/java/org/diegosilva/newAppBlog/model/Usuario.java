package org.diegosilva.newAppBlog.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @NotNull(message = "Nome")
    @Getter
    @Setter
    private String nome;



    @NotNull(message = "Necessario Email")
    @Email(message = "Necessario Email")
    @Getter
    @Setter
    private String email;

    @Size(min = 5, max = 100, message = "Necessario min 5 caracteres")
    @Getter
    @Setter
    private String senha;


    @OneToMany(mappedBy = "criador", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"criador"})
    private List<Postagem> minhasPostagens = new ArrayList<>();
}