package com.evaluaciontecnica.carritocompra.services;

import com.evaluaciontecnica.carritocompra.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductoService {

    Producto save(Producto producto);

    Boolean delete(Integer id);
    Producto findById(Integer id);
    Page<Producto> findAllPageable(Pageable pageable);
}
