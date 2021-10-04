package org.diegosilva.newAppBlog.repository;

import org.apache.catalina.LifecycleState;
import org.diegosilva.newAppBlog.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemaRepository extends JpaRepository<Tema, Long>{
    public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);



}