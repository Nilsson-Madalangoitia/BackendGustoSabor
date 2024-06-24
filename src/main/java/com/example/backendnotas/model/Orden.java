package com.example.backendnotas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="precio", nullable = false)
    private Double precio;

    @Column(name="cantidad", nullable = false)
    private Double cantidad;

    @Column(name="total", nullable = false)
    private Double total;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false, foreignKey = @ForeignKey(name = "FK_pedido_orden"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false, foreignKey = @ForeignKey(name = "FK_servicio_orden"))
    private Servicio servicio;

}
