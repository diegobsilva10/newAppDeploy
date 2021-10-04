package org.diegosilva.newAppBlog.repository;

import org.diegosilva.newAppBlog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);



}