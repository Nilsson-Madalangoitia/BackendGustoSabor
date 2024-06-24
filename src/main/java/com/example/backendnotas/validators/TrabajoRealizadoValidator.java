package com.example.backendnotas.validators;

import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.model.TrabajoRealizado;

public class TrabajoRealizadoValidator {

    public static void validate(TrabajoRealizado trabajoRealizado){

        if(trabajoRealizado.getTitulo() == null || trabajoRealizado.getTitulo().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El titulo es requerido");
        }

        if(trabajoRealizado.getTitulo().length() > 100) {
            throw new IncorrectResourceRequestException("El titulo excede los 100 caracteres requeridos");
        }

        if(trabajoRealizado.getDescripcion() == null || trabajoRealizado.getDescripcion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La descripción es requerida");
        }

        if(trabajoRealizado.getDescripcion().length() > 200) {
            throw new IncorrectResourceRequestException("La descripción excede los 200 caracteres requeridos");
        }

        if(trabajoRealizado.getFecha() == null || trabajoRealizado.getFecha().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La fecha es requerido");
        }

        if(trabajoRealizado.getFecha().length() > 10) {
            throw new IncorrectResourceRequestException("La fecha excede el tamaño de 10 caracteres requeridos");
        }

    }

}
