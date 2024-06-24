package com.example.backendnotas.validators;

import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.model.Servicio;

public class ServicioValidator {

    public static void validate(Servicio servicio){

        if(servicio.getNombre() == null || servicio.getNombre().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");
        }

        if(servicio.getNombre().length() > 50) {
            throw new IncorrectResourceRequestException("El nombre excede los 50 caracteres requeridos");
        }

        if(servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La descripción es requerida");
        }

        if(servicio.getDescripcion().length() > 200) {
            throw new IncorrectResourceRequestException("La descripción excede los 200 caracteres requeridos");
        }

        if(servicio.getPrecio() == null) {
            throw new IncorrectResourceRequestException("El precio es requerido");
        }

        if(servicio.getPrecio() < 0) {
            throw new IncorrectResourceRequestException("El precio no puede ser menor a 0");
        }

        if(servicio.getIdcategoria() == null) {
            throw new IncorrectResourceRequestException("El id de la categoria es requerido");
        }

        if(servicio.getIdcategoria() <= 0) {
            throw new IncorrectResourceRequestException("Coloque un id de categoria existente");
        }

    }

}
