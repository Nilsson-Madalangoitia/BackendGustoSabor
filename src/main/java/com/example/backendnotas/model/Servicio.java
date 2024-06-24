package com.example.backendnotas.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idcategoria", nullable = false)
    private Integer idcategoria;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "status", nullable = false)
    private Boolean status = true;

}
