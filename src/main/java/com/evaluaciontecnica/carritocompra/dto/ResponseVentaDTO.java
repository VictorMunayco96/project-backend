package com.evaluaciontecnica.carritocompra.dto;

import com.evaluaciontecnica.carritocompra.entity.DetalleVenta;
import com.evaluaciontecnica.carritocompra.entity.Venta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVentaDTO {

    private Venta venta;
    private List<DetalleVenta> detalleVentaList;


}
