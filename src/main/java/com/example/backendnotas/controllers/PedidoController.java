package com.example.backendnotas.controllers;

import com.example.backendnotas.model.Pedido;
import com.example.backendnotas.services.impl.PedidoServiceImpl;
import com.example.backendnotas.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoServiceImpl service;

    public PedidoController(PedidoServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Pedido>> registrar(@RequestBody Pedido pedido){
        Pedido newObjeto = service.registrar(pedido);
        return new WrapperResponse<>(true,"success",newObjeto).createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Pedido>> actualizar(@RequestBody Pedido pedido){
        Pedido updObjeto = service.actualizar(pedido);
        return new WrapperResponse<Pedido>(true, "success", updObjeto)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Pedido>>> listar(){
        List<Pedido> objetos = service.listar();
        return new WrapperResponse<>(true, "success", objetos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Pedido>> buscarPorId(@PathVariable("id") Integer id){
        Pedido objeto = service.buscarPorId(id);
        return new WrapperResponse<>(true, "success", objeto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.OK);
    }

}
