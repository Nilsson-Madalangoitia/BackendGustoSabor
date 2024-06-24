package com.example.backendnotas.services.impl;

import com.example.backendnotas.exceptions.GeneralServiceException;
import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.exceptions.ResourceNotFoundException;
import com.example.backendnotas.model.Solicitud;
import com.example.backendnotas.repositories.SolicitudRepository;
import com.example.backendnotas.services.GenericService;
import com.example.backendnotas.validators.SolicitudValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements GenericService<Solicitud> {

    private final SolicitudRepository repository;

    public SolicitudServiceImpl(SolicitudRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Solicitud registrar(Solicitud solicitud){
        try {
            SolicitudValidator.validate(solicitud);
            return repository.save(solicitud);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public Solicitud actualizar(Solicitud solicitud){
        SolicitudValidator.validate(solicitud);
        Solicitud objetoActualizado = repository.findById(solicitud.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        objetoActualizado.setNombres(solicitud.getNombres());
        objetoActualizado.setApellidos(solicitud.getApellidos());
        objetoActualizado.setTelefono(solicitud.getApellidos());
        objetoActualizado.setTipo(solicitud.getTipo());
        objetoActualizado.setAtendido(solicitud.getAtendido());
        return repository.save(objetoActualizado);

    }

    @Transactional(readOnly = true)
    public List<Solicitud> listar(){
        return repository.findAll();
    }

    public Solicitud buscarPorId(Integer id){
        Optional<Solicitud> objeto = repository.findById(id);
        return objeto.orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Transactional
    public void eliminar(Integer id){
        Solicitud solicitud = this.buscarPorId(id);
        repository.delete(solicitud);
    }

}
