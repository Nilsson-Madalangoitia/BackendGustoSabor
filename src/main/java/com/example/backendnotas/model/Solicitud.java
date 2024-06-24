package com.example.backendnotas.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres", length = 20, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    //informacion = I - Presupuesto = P
    @Column(name = "tipo", length = 1, nullable = false)
    private String tipo;

    //si = S - no = N
    @Column(name = "atendido", length = 1, nullable = false)
    private String atendido;

    @Column(name = "status", nullable = false)
    private Boolean status = true;

}
