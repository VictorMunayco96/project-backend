package com.evaluaciontecnica.carritocompra.web.controller;

import com.evaluaciontecnica.carritocompra.entity.Cliente;
import com.evaluaciontecnica.carritocompra.entity.Producto;
import com.evaluaciontecnica.carritocompra.services.ClienteService;
import com.evaluaciontecnica.carritocompra.services.ProductoService;
import com.evaluaciontecnica.carritocompra.utilitarios.Utilitarios;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    private Utilitarios utilitarios;


    @PostMapping("/insert/producto")
    @ApiOperation("Crea nuevo registro en la tabla")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Producto producto, BindingResult result) {

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {

            productoService.save(producto);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Registro exitoso");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


    @PutMapping("/update/{idProducto}")
    @ApiOperation("Modifica un solo registro en la tabla")
    public ResponseEntity<?> update(@Valid @RequestBody Producto producto, @PathVariable int idProducto, BindingResult result) {


        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        Producto actual = productoService.findById(idProducto);
        try {

            actual.setNombre(utilitarios.isNull(actual.getNombre(), producto.getNombre()).toString());
            actual.setPrecio(Double.parseDouble(utilitarios.isNull(actual.getPrecio(), producto.getPrecio()).toString()));

            productoService.save(actual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Actualizacion exitosa");


        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);


    }

    @DeleteMapping("/delete/{idProducto}")
    @ApiOperation("Elimina Producto")
    public ResponseEntity<?> delete(@PathVariable("idProducto") int idProducto) {

        Map<String, Object> response = new HashMap<>();

        try {

            Boolean statusSend = productoService.delete(idProducto);

            response.put("mensaje", "Producto Eliminado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.put("mensaje", "Error al Eliminar");

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllPageable")
    @ApiOperation("Obtiene toda la data de la tabla")
    public ResponseEntity<?> getAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findAllPageable(pageable));

    }


}
