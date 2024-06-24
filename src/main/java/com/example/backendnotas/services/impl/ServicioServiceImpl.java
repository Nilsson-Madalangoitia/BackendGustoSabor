package com.example.backendnotas.services.impl;

import com.example.backendnotas.exceptions.GeneralServiceException;
import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.exceptions.ResourceNotFoundException;
import com.example.backendnotas.model.Servicio;
import com.example.backendnotas.repositories.ServicioRepository;
import com.example.backendnotas.services.GenericService;
import com.example.backendnotas.validators.ServicioValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements GenericService<Servicio> {

    private final ServicioRepository servicioRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Transactional
    public Servicio registrar(Servicio servicio){
        try {
            ServicioValidator.validate(servicio);
            return servicioRepository.save(servicio);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public Servicio actualizar(Servicio servicio){
        ServicioValidator.validate(servicio);

        Servicio objetoActualizado = servicioRepository.findById(servicio.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));

        objetoActualizado.setIdcategoria(servicio.getIdcategoria());
        objetoActualizado.setNombre(servicio.getNombre());
        objetoActualizado.setDescripcion(servicio.getDescripcion());
        objetoActualizado.setPrecio(servicio.getPrecio());

        return servicioRepository.save(objetoActualizado);

    }

    @Transactional(readOnly = true)
    public List<Servicio> listar(){
        return servicioRepository.findAll();
    }

    public Servicio buscarPorId(Integer id){
        Optional<Servicio> objeto = servicioRepository.findById(id);
        return objeto.orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Transactional
    public void eliminar(Integer id){
        Servicio objeto = this.buscarPorId(id);
        servicioRepository.delete(objeto);
    }

    @Transactional
    public List<Servicio> listarServiciosPorCategoria(Integer idcategoria){
        return servicioRepository.findByIdcategoria(idcategoria);
    }

}
