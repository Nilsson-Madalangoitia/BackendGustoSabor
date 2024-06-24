package com.example.backendnotas.services.impl;

import com.example.backendnotas.exceptions.GeneralServiceException;
import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.exceptions.ResourceNotFoundException;
import com.example.backendnotas.model.TrabajoRealizado;
import com.example.backendnotas.repositories.TrabajoRealizadoRepository;
import com.example.backendnotas.services.GenericService;
import com.example.backendnotas.validators.TrabajoRealizadoValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajoRealizadoServiceImpl implements GenericService<TrabajoRealizado> {

    private final TrabajoRealizadoRepository repository;

    public TrabajoRealizadoServiceImpl(TrabajoRealizadoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public TrabajoRealizado registrar(TrabajoRealizado trabajoRealizado){
        try {
            TrabajoRealizadoValidator.validate(trabajoRealizado);
            return repository.save(trabajoRealizado);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public TrabajoRealizado actualizar(TrabajoRealizado trabajoRealizado){
        TrabajoRealizadoValidator.validate(trabajoRealizado);

        TrabajoRealizado objetoActualizado = repository.findById(trabajoRealizado.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));

        objetoActualizado.setTitulo(trabajoRealizado.getTitulo());
        objetoActualizado.setDescripcion(trabajoRealizado.getDescripcion());
        objetoActualizado.setFecha(trabajoRealizado.getFecha());

        return repository.save(objetoActualizado);

    }

    @Transactional(readOnly = true)
    public List<TrabajoRealizado> listar(){
        return repository.findAll();
    }

    public TrabajoRealizado buscarPorId(Integer id){
        Optional<TrabajoRealizado> objeto = repository.findById(id);
        return objeto.orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Transactional
    public void eliminar(Integer id){
        TrabajoRealizado trabajoRealizado = this.buscarPorId(id);
        repository.delete(trabajoRealizado);
    }

}
