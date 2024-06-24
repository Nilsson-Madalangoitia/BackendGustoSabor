package com.example.backendnotas.services.impl;

import com.example.backendnotas.exceptions.GeneralServiceException;
import com.example.backendnotas.exceptions.IncorrectResourceRequestException;
import com.example.backendnotas.exceptions.ResourceNotFoundException;
import com.example.backendnotas.model.Categoria;
import com.example.backendnotas.repositories.CategoriaRepository;
import com.example.backendnotas.validators.CategoriaValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Categoria registrar(Categoria categoria){
        try {
            CategoriaValidator.validate(categoria);
            return repository.save(categoria);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public Categoria actualizar(Categoria categoria){
        CategoriaValidator.validate(categoria);
        Categoria objetoActualizado = repository.findById(categoria.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        objetoActualizado.setNombre(categoria.getNombre());
        return repository.save(objetoActualizado);
    }

    @Transactional(readOnly = true)
    public List<Categoria> listar(){
        return repository.findAll();
    }

    public Categoria buscarPorId(Integer id){
        Optional<Categoria> objeto = repository.findById(id);
        return objeto.orElseThrow(() -> new ResourceNotFoundException("Not found"));
    }

    @Transactional
    public void eliminar(Integer id){
        Categoria categoria = this.buscarPorId(id);
        repository.delete(categoria);
    }

}
