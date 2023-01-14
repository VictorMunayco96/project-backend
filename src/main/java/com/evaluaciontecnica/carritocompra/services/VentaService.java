package com.evaluaciontecnica.carritocompra.services;

import com.evaluaciontecnica.carritocompra.dto.ResponseVentaDTO;
import com.evaluaciontecnica.carritocompra.entity.Venta;

import java.util.Date;
import java.util.List;

public interface VentaService {

    Venta save(Venta venta);
    ResponseVentaDTO findById(Integer idVenta);
    List<ResponseVentaDTO> findByFecha(Date fecha);



}
