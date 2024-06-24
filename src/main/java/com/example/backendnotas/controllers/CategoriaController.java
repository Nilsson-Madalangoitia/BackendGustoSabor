package com.example.backendnotas.controllers;

import com.example.backendnotas.model.Categoria;
import com.example.backendnotas.services.impl.CategoriaServiceImpl;
import com.example.backendnotas.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaServiceImpl service;

    public CategoriaController(CategoriaServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Categoria>> registrar(@RequestBody Categoria categoria){
        Categoria newObjeto = service.registrar(categoria);
        return new WrapperResponse<Categoria>(true, "success", newObjeto)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Categoria>> actualizar(@RequestBody Categoria categoria){
        Categoria updObjeto = service.actualizar(categoria);
        return new WrapperResponse<Categoria>(true, "success", updObjeto)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Categoria>>> listar(){
        List<Categoria> objetos = service.listar();
        return new WrapperResponse<>(true, "success", objetos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Categoria>> buscarPorId(@PathVariable("id") Integer id){
        Categoria objeto = service.buscarPorId(id);
        return new WrapperResponse<>(true, "success", objeto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.OK);
    }

}
