package org.diegosilva.newAppBlog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe utilizada como entidade no banco de dados para a criação das postagens.
 *
 * @author Diego Silva
 * @since 1.0
 *
 */
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Entity (name = "Postagem")
@Table(name = "tb_postagem")
public class Postagem implements Serializable {
    private static final long serialVersionUID = 1L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;

    @NotBlank
    @Size(max= 45, message = "Maximo 45 caracteres")
    @Getter @Setter private String titulo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "minhasPostagens" })
    @Getter @Setter private Usuario criador;

    @NotBlank
    @Size(max = 300, message = "Maximo 300 caracteres")
    @Getter @Setter private String texto;

    @JsonFormat(pattern = "yyy-MM-dd")
    @Getter @Setter private LocalDate dataPostagem = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({ "listaDePostagens" })
    @Getter @Setter private Tema tema;




}