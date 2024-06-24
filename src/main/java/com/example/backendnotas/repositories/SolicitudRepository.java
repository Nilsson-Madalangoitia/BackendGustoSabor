package com.example.backendnotas.repositories;

import com.example.backendnotas.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
}
