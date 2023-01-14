package com.evaluaciontecnica.carritocompra.web.controller;

import com.evaluaciontecnica.carritocompra.dto.RequestVentaDTO;
import com.evaluaciontecnica.carritocompra.dto.ResponseVentaDTO;
import com.evaluaciontecnica.carritocompra.entity.Cliente;
import com.evaluaciontecnica.carritocompra.entity.Venta;
import com.evaluaciontecnica.carritocompra.services.DetalleVentaService;
import com.evaluaciontecnica.carritocompra.services.ProductoService;
import com.evaluaciontecnica.carritocompra.services.VentaService;
import com.evaluaciontecnica.carritocompra.utilitarios.Utilitarios;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private DetalleVentaService detalleVentaService;


    @PostMapping("/insert/venta")
    @ApiOperation("Crea nuevo registro en la tabla")
    public ResponseEntity<?> create(@RequestBody RequestVentaDTO requestVentaDTO) {

        Map<String, Object> response = new HashMap<>();



        try {

            ventaService.save(
                    requestVentaDTO.getVenta()
                    );


            requestVentaDTO.getDetalleVenta().forEach(detalleVenta ->{
                detalleVentaService.save(detalleVenta);
            });






        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Registro exitoso");



        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


    @GetMapping("/findById/{idVenta}")
    @ApiOperation("Obtiene data filtrada por ID")
    public ResponseVentaDTO getFindId(@PathVariable("idVenta") int idVenta) {
        return ventaService.findById(idVenta);
    }

    @GetMapping("/findByFecha/{fecha}")
    @ApiOperation("Obtiene data filtrada por Fecha")
    public List<ResponseVentaDTO> getFindFecha(@PathVariable("fecha") String fecha) {

        Date dataFormateada = null;

        try{

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            dataFormateada = formato.parse(fecha);
        }catch(Exception e){

        }


        return ventaService.findByFecha(dataFormateada);
    }


}
