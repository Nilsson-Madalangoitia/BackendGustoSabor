package com.example.backendnotas.controllers;

import com.example.backendnotas.model.Solicitud;
import com.example.backendnotas.services.impl.SolicitudServiceImpl;
import com.example.backendnotas.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudServiceImpl service;

    public SolicitudController(SolicitudServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Solicitud>> registrar(@RequestBody Solicitud solicitud){
        Solicitud newObjeto = service.registrar(solicitud);
        return new WrapperResponse<Solicitud>(true, "success", newObjeto)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Solicitud>> actualizar(@RequestBody Solicitud solicitud){
        Solicitud updObjeto = service.actualizar(solicitud);
        return new WrapperResponse<Solicitud>(true, "success", updObjeto)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Solicitud>>> listar(){
        List<Solicitud> objetos = service.listar();
        return new WrapperResponse<>(true, "success", objetos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Solicitud>> buscarPorId(@PathVariable("id") Integer id){
        Solicitud objeto = service.buscarPorId(id);
        return new WrapperResponse<>(true, "success", objeto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.OK);
    }

}
