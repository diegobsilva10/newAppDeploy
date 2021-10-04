package org.diegosilva.newAppBlog.repository;


import org.diegosilva.newAppBlog.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByEmail(String email);

    List<Usuario> findAllByNomeContainingIgnoreCase(String nome);




}