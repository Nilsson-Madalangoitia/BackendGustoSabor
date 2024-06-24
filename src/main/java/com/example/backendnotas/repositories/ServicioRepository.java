package com.example.backendnotas.repositories;

import com.example.backendnotas.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    List<Servicio> findByIdcategoria(Integer idcategoria);
}
