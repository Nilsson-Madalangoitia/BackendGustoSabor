package com.example.backendnotas.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "correo", length = 50, nullable = false)
    private String correo;

    @Column(name = "nombres", length = 20, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "dni", length = 8, nullable = false)
    private String dni;

    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @Column(name = "fecha", length = 10, nullable = false)
    private String fecha;

    @Column(name="total", nullable = false)
    private Double total;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<Orden> items;

}
