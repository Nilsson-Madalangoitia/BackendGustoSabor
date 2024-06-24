package com.example.backendnotas.validators;

import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.model.Solicitud;

public class SolicitudValidator {

    public static void validate(Solicitud solicitud) {

        if (solicitud.getNombres() == null || solicitud.getNombres().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");
        }

        if (solicitud.getNombres().length() > 20) {
            throw new IncorrectResourceRequestException("El nombre excede los 20 caracteres requeridos");
        }

        if (solicitud.getApellidos() == null || solicitud.getApellidos().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("Los apellidos son requeridos");
        }

        if (solicitud.getApellidos().length() > 50) {
            throw new IncorrectResourceRequestException("Los apellidos exceden los 50 caracteres requeridos");
        }

        if (solicitud.getTelefono() == null || solicitud.getTelefono().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El telefono es requerida");
        }

        if (solicitud.getTelefono().length() > 20) {
            throw new IncorrectResourceRequestException("El telefono excede los 9 caracteres requeridos");
        }

        if (solicitud.getTipo() == null || solicitud.getTipo().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El tipo es requerida");
        }

        if (solicitud.getTipo().length() > 1) {
            throw new IncorrectResourceRequestException("El tipo excede los 1 caracteres requeridos");
        }

        if (solicitud.getAtendido() == null || solicitud.getAtendido().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El estado de atendido es requerida");
        }

        if (solicitud.getAtendido().length() > 1) {
            throw new IncorrectResourceRequestException("El estado de atendido excede los 1 caracteres requeridos");
        }

    }
}
