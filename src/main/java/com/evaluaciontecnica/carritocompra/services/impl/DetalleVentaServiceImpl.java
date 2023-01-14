package com.evaluaciontecnica.carritocompra.services.impl;

import com.evaluaciontecnica.carritocompra.entity.DetalleVenta;
import com.evaluaciontecnica.carritocompra.repository.DetalleVentaRepository;
import com.evaluaciontecnica.carritocompra.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    @Autowired
    DetalleVentaRepository detalleVentaRepository;


    @Override
    public DetalleVenta save(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }
}
