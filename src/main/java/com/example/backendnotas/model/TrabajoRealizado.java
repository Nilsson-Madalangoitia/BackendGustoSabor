package com.example.backendnotas.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "trabajorealizado")
public class TrabajoRealizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String descripcion;

    @Column(name = "fecha", length = 10, nullable = false)
    private String fecha;

    @Column(name = "status", nullable = false)
    private Boolean status = true;

}
