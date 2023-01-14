package com.evaluaciontecnica.carritocompra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Venta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Venta {

    @Id
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date fecha;


    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = true, updatable = true)
    private Cliente cliente;




}
