package com.example.backendnotas.validators;

import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.model.Pedido;

public class PedidoValidator {

    public static void validate(Pedido pedido){

        if(pedido.getCorreo() == null || pedido.getCorreo().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El correo es requerido");
        }

        if(pedido.getCorreo().length() > 50) {
            throw new IncorrectResourceRequestException("El correo excede los 50 caracteres requeridos");
        }

        if(pedido.getNombres() == null || pedido.getNombres().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerida");
        }

        if(pedido.getNombres().length() > 20) {
            throw new IncorrectResourceRequestException("El nombre excede los 20 caracteres requeridos");
        }

        if(pedido.getApellidos() == null || pedido.getApellidos().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("Los apellidos son requeridos");
        }

        if(pedido.getApellidos().length() > 50) {
            throw new IncorrectResourceRequestException("Los apellidos exceden los 50 caracteres requeridos");
        }

        if(pedido.getDni() == null || pedido.getDni().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El DNI es requerido");
        }

        if(pedido.getDni().length() > 8) {
            throw new IncorrectResourceRequestException("El DNI excede los 8 caracteres requeridos");
        }

        if(pedido.getTelefono() == null || pedido.getTelefono().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El telefono es requerido");
        }

        if(pedido.getTelefono().length() > 9) {
            throw new IncorrectResourceRequestException("El telefono excede los 9 caracteres requeridos");
        }

        if(pedido.getDireccion() == null || pedido.getDireccion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La direccion es requerida");
        }

        if(pedido.getDireccion().length() > 100) {
            throw new IncorrectResourceRequestException("La direccion excede los 100 caracteres requeridos");
        }

        if(pedido.getFecha() == null || pedido.getFecha().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La fecha es requerida");
        }

        if(pedido.getFecha().length() > 10) {
            throw new IncorrectResourceRequestException("La fecha excede los 10 caracteres requeridos");
        }

    }

}
