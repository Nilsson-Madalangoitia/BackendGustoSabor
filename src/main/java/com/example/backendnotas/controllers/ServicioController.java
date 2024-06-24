package com.example.backendnotas.controllers;

import com.example.backendnotas.model.Servicio;
import com.example.backendnotas.services.impl.ServicioServiceImpl;
import com.example.backendnotas.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioServiceImpl service;

    public ServicioController(ServicioServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Servicio>> registrar(@RequestBody Servicio servicio){
        Servicio newObjeto = service.registrar(servicio);
        return new WrapperResponse<Servicio>(true, "success", newObjeto)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Servicio>> actualizar(@RequestBody Servicio servicio){
        Servicio updObjeto = service.actualizar(servicio);
        return new WrapperResponse<Servicio>(true, "success", updObjeto)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Servicio>>> listar(){
        List<Servicio> objetos = service.listar();
        return new WrapperResponse<>(true, "success", objetos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Servicio>> buscarPorId(@PathVariable("id") Integer id){
        Servicio objeto = service.buscarPorId(id);
        return new WrapperResponse<>(true, "success", objeto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<WrapperResponse<List<Servicio>>> listarServiciosPorCategoria(@PathVariable("id") Integer id){
        List<Servicio> objetos = service.listarServiciosPorCategoria(id);
        return new WrapperResponse<>(true, "success", objetos).createResponse(HttpStatus.OK);
    }

}
