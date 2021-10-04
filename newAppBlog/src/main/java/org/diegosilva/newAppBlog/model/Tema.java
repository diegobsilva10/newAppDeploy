package org.diegosilva.newAppBlog.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

/**
 * Classe utilizada como entidade no banco de dados para a criação das postagens.
 *
 * @author Diego Silva
 * @since 1.0
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Tema")
@Table(name = "tb_tema")
public class Tema implements Serializable {
    private static final long serialVersionUIO = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private long id;

    @NotBlank(message = "Descrição do tema")
    @Getter @Setter private String descricao;

    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tema")
    @Getter @Setter private List<Postagem> listadePostagem;




}