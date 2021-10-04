package org.diegosilva.newAppBlog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.diegosilva.newAppBlog.model.Tema;
import org.diegosilva.newAppBlog.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "Controlador de Temas", description = "Utilitario de Temas")
public class TemaController {
    @Autowired
    private TemaRepository repository;

    @ApiOperation(value="Retorna uma Lista de Temas")
    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){
        return ResponseEntity.ok((repository.findAll()));
    }

    @ApiOperation(value="Retorna um tema único")
    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById (@PathVariable long id){
        return repository.findById(id).map(resp ->  ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
    @ApiOperation(value="Retorna um tema por nome")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Tema>> getByName (@PathVariable String nome){
        return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
    }



    @ApiOperation(value="Salva um tema")
    @PostMapping
    public ResponseEntity<Tema> post (@RequestBody Tema  tema){
        return ResponseEntity.status(HttpStatus.CREATED).body((repository.save(tema)));
    }

    @ApiOperation(value="Atualiza um tema")
    @PutMapping
    public ResponseEntity<Tema> put (@RequestBody Tema  tema){
        return ResponseEntity.ok(repository.save(tema));
    }

    @ApiOperation(value="Deleta um tema único")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteById(id);
    }

}