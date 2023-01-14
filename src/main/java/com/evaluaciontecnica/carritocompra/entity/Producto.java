package com.evaluaciontecnica.carritocompra.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {

    @Id
    @Column(name="id")
    private Integer id;

    private String nombre;

    private Double precio;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<DetalleVenta> detalleVentas;

}
