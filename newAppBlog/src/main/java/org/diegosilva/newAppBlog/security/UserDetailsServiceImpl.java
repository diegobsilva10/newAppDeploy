package org.diegosilva.newAppBlog.security;



import org.diegosilva.newAppBlog.model.Usuario;
import org.diegosilva.newAppBlog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private @Autowired
    UsuarioRepository repositorio;

    /**
     * Metodo utilizado para verificar existencia do usuario no banco e retorna um
     * UserDetailsImplements com usuario
     *
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repositorio.findByEmail(username);

        if (usuario.isPresent()) {
            return new UserDetailsImpl(usuario.get());
        } else {
            throw new UsernameNotFoundException(username + " not found.");


        }
    }
}