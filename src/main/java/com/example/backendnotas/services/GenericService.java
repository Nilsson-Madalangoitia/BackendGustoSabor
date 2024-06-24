package com.example.backendnotas.services;

import java.util.List;

public interface GenericService<T> {
    T registrar(T objeto);
    T actualizar(T objeto);
    List<T> listar();
    T buscarPorId(Integer id);
    void eliminar(Integer id);
}
