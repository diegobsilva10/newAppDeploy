package org.diegosilva.newAppBlog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.diegosilva.newAppBlog.model.Postagem;
import org.diegosilva.newAppBlog.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/postagens")
@Api(tags = "Controlador de Postagem", description = "Utilitario de Postagens")
public class PostagemController {
    @Autowired
    private PostagemRepository repository;

    @ApiOperation(value="Retorna uma lista de Postagens")
    @GetMapping
    public ResponseEntity<List<Postagem>> GetALL(){
        return ResponseEntity.ok(repository.findAll());
    }

    @ApiOperation(value="Retorna uma postagem por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Postagem> GetByID(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound()
                .build());
    }

    @ApiOperation(value="Retorna uma postagem por titulo")
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }



    @ApiOperation(value="Salva uma postagem")
    @PostMapping
    public ResponseEntity<Postagem> post (@RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

    @ApiOperation(value="Atualiza uma postagem")
    @PutMapping
    public ResponseEntity<Postagem> put (@RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
    }
    @ApiOperation(value="Deleta uma única postagem")
    @DeleteMapping ("/{id}")
    public void delete (@PathVariable long id){
        repository.deleteById(id);
    }

}