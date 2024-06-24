package com.example.backendnotas.services.impl;

import com.example.backendnotas.exceptions.ResourceNotFoundException;
import com.example.backendnotas.model.Orden;
import com.example.backendnotas.model.Pedido;
import com.example.backendnotas.model.Servicio;
import com.example.backendnotas.repositories.PedidoRepository;
import com.example.backendnotas.repositories.ServicioRepository;
import com.example.backendnotas.services.GenericService;
import com.example.backendnotas.validators.PedidoValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements GenericService<Pedido> {

    private final PedidoRepository pedidoRepository;
    private final ServicioRepository servicioRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ServicioRepository servicioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.servicioRepository = servicioRepository;
    }

    @Transactional
    public Pedido registrar(Pedido pedido){
        PedidoValidator.validate(pedido);
        double total=0;
        for(Orden item:pedido.getItems()){
            Servicio servicio = servicioRepository.findById(item.getServicio().getId())
                    .orElseThrow(()->new ResourceNotFoundException("No existe el servicio "+item.getServicio().getId()));

            item.setPrecio(servicio.getPrecio());
            item.setTotal(servicio.getPrecio()*item.getCantidad());
            total+= item.getTotal();
        }
        pedido.setTotal(total);
        pedido.getItems().forEach(line->line.setPedido(pedido));
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido actualizar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    @Transactional(readOnly = true)
    public List<Pedido> listar(){
        return pedidoRepository.findAll();
    }

    @Transactional
    public void eliminar(Integer id){
        pedidoRepository.deleteById(id);
    }

    public Pedido buscarPorId(Integer id){
        Optional<Pedido> objeto = pedidoRepository.findById(id);
        return objeto.orElseThrow(() -> new ResourceNotFoundException("Pedido not found"));
    }

}
