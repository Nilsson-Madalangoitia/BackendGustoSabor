package com.example.backendnotas.services;

import com.example.backendnotas.model.Usuario;
import com.example.backendnotas.model.UsuarioRol;

import java.util.List;
import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public List<Usuario> listarUsuarios();

    public void eliminarUsuario(Long usuarioId);

}
