package com.example.backendnotas.controllers;

import com.example.backendnotas.model.TrabajoRealizado;
import com.example.backendnotas.services.impl.TrabajoRealizadoServiceImpl;
import com.example.backendnotas.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajos-realizados")
public class TrabajoRealizadoController {

    private final TrabajoRealizadoServiceImpl service;

    public TrabajoRealizadoController(TrabajoRealizadoServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<TrabajoRealizado>> registrar(@RequestBody TrabajoRealizado trabajoRealizado){
        TrabajoRealizado newObjeto = service.registrar(trabajoRealizado);
        return new WrapperResponse<TrabajoRealizado>(true, "success", newObjeto)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<TrabajoRealizado>> actualizar(@RequestBody TrabajoRealizado trabajoRealizado){
        TrabajoRealizado updObjeto = service.actualizar(trabajoRealizado);
        return new WrapperResponse<TrabajoRealizado>(true, "success", updObjeto)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<TrabajoRealizado>>> listar(){
        List<TrabajoRealizado> objetos = service.listar();
        return new WrapperResponse<>(true, "success", objetos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<TrabajoRealizado>> buscarPorId(@PathVariable("id") Integer id){
        TrabajoRealizado objeto = service.buscarPorId(id);
        return new WrapperResponse<>(true, "success", objeto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.OK);
    }

}
