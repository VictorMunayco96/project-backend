package com.evaluaciontecnica.carritocompra.repository;

import com.evaluaciontecnica.carritocompra.entity.Venta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Integer> {



    @Query("SELECT h FROM Venta h where h.fecha = ?1 ")
    List<Venta> findByFecha(Date fecha);

}
