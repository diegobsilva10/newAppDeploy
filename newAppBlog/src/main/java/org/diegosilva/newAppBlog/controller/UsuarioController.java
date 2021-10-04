package org.diegosilva.newAppBlog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.diegosilva.newAppBlog.model.UserLogin;
import org.diegosilva.newAppBlog.model.Usuario;
import org.diegosilva.newAppBlog.repository.UsuarioRepository;
import org.diegosilva.newAppBlog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
@Api(tags = "Controlador de Usuario", description = "Utilitario de Usuarios")
public class UsuarioController {




    private @Autowired
    UsuarioRepository repositorio;
    private @Autowired
    UsuarioService servicos;

    @ApiOperation(value="Salva usuario")
    @PostMapping("/salvar")
    public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody Usuario novoUsuario) {
        Optional<Object> objetoCadastrado = servicos.cadastrarUsuario(novoUsuario);

        if (objetoCadastrado.isPresent()) {
            return ResponseEntity.status(201).body(objetoCadastrado.get());
        } else {
            return ResponseEntity.status(400).build();
        }

    }


    @ApiOperation(value="Autentica usuario")
    @PutMapping("/autenticar")
    public ResponseEntity<Object> pegarCredenciais(@Valid @RequestBody UserLogin loginSenha) {
        Optional<?> objetoCredenciado = servicos.pegarCredenciais(loginSenha);

        if (objetoCredenciado.isPresent()) {
            return ResponseEntity.status(201).body(objetoCredenciado.get());
        } else {
            return ResponseEntity.status(400).build();
        }

    }


    @GetMapping("/todos")
    public ResponseEntity<Object> buscarTodos() {
        List<Usuario> listaUsuarios = repositorio.findAll();

        if (listaUsuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(listaUsuarios);
        }

    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id_usuario") Long id) {
        Optional<Usuario> objetoUsuario = repositorio.findById(id);
        if (objetoUsuario.isPresent()) {
            return ResponseEntity.status(200).body(objetoUsuario.get());
        } else {
            return ResponseEntity.status(204).build();
        }
    }


    @GetMapping("/pesquisa")
    public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(defaultValue = "") String nome) {
        return ResponseEntity.status(200).body(repositorio.findAllByNomeContainingIgnoreCase(nome));
    }

    @PutMapping("/alterar")
    public ResponseEntity<Object> alterar(@Valid @RequestBody UserLogin usuarioParaAlterar) {
        Optional<?> objetoAlterado = servicos.alterarUsuario(usuarioParaAlterar);

        if (objetoAlterado.isPresent()) {
            return ResponseEntity.status(201).body(objetoAlterado.get());
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/deletar/{id_usuario}")
    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
        Optional<Usuario> objetoExistente = repositorio.findById(idUsuario);
        if (objetoExistente.isPresent()) {
            repositorio.deleteById(idUsuario);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(400).build();
        }

    }

}