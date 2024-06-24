package com.example.backendnotas.validators;

import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.model.Categoria;

public class CategoriaValidator {

    public static void validate(Categoria categoria){

        if(categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");
        }

        if(categoria.getNombre().length() > 20) {
            throw new IncorrectResourceRequestException("El nombre excede los 20 caracteres requeridos");
        }

    }

}
