package com.evaluaciontecnica.carritocompra.services.impl;

import com.evaluaciontecnica.carritocompra.dto.ResponseVentaDTO;
import com.evaluaciontecnica.carritocompra.entity.DetalleVenta;
import com.evaluaciontecnica.carritocompra.entity.Venta;
import com.evaluaciontecnica.carritocompra.repository.DetalleVentaRepository;
import com.evaluaciontecnica.carritocompra.repository.VentaRepository;
import com.evaluaciontecnica.carritocompra.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    DetalleVentaRepository detalleVentaRepository;

    @Override
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public ResponseVentaDTO findById(Integer idVenta) {

        ResponseVentaDTO responseVentaDTO = new ResponseVentaDTO();

        responseVentaDTO.setVenta(ventaRepository.findById(idVenta).orElse(null));
        responseVentaDTO.setDetalleVentaList(detalleVentaRepository.findByIdVenta(idVenta));

        return responseVentaDTO;
    }

    @Override
    public List<ResponseVentaDTO> findByFecha(Date fecha) {

        List<Venta> ventas= ventaRepository.findByFecha(fecha);

        List<ResponseVentaDTO> responseVentaDTOs = new ArrayList<>();

        ventas.forEach(x ->
                {
                    ResponseVentaDTO responseVentaDTO = new ResponseVentaDTO();
                    responseVentaDTO.setVenta(x);

                    List<DetalleVenta> detalleVentas = detalleVentaRepository.findByIdVenta(x.getId());
                    responseVentaDTO.setDetalleVentaList(detalleVentas);


                    responseVentaDTOs.add(responseVentaDTO);



                }
        );

        return responseVentaDTOs;
    }
}
