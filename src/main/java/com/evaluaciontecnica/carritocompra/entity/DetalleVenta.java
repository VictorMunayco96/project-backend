package com.evaluaciontecnica.carritocompra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="detalle_venta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleVenta {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name ="id_venta", insertable = true, updatable = true)
    @JsonIgnore
    private Venta venta;

    @ManyToOne
    @JoinColumn(name ="id_producto", insertable = true, updatable = true)
    private Producto producto;


}
