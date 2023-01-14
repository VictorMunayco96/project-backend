package com.evaluaciontecnica.carritocompra.repository;

import com.evaluaciontecnica.carritocompra.entity.DetalleVenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, Integer> {

    @Query("Select h from DetalleVenta h where h.venta.id=?1")
    List<DetalleVenta> findByIdVenta(Integer idVenta);



}
