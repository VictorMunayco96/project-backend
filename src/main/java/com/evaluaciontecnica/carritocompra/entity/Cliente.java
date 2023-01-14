package com.evaluaciontecnica.carritocompra.entity;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @Column(name = "id")
    private Integer id;

    private String nombres;

    private String apellidos;

    private String dni;

    private String telefono;

    private String email;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Venta> ventas;


}
