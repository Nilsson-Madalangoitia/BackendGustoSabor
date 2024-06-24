package com.example.backendnotas.controllers;

import com.example.backendnotas.model.Rol;
import com.example.backendnotas.model.Usuario;
import com.example.backendnotas.model.UsuarioRol;
import com.example.backendnotas.services.UsuarioService;
import com.example.backendnotas.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioControlador {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{

        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolID(2L);
        rol.setNombre("ADMIN");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Usuario>>> listar(){
        List<Usuario> objetos = usuarioService.listarUsuarios();
        return new WrapperResponse<>(true, "success", objetos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usuarioService.obtenerUsuario(username);
    }
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

}
