package com.evaluaciontecnica.carritocompra.services.impl;

import com.evaluaciontecnica.carritocompra.entity.Producto;
import com.evaluaciontecnica.carritocompra.repository.ProductoRepository;
import com.evaluaciontecnica.carritocompra.services.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }


    @Override
    public Boolean delete(Integer id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            log.error("Error en ProductoServiceImpl:" + ex.getMessage());
            return false;
        }


    }

    @Override
    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAllPageable(Pageable pageable) {

        return productoRepository.findAll(pageable);


    }
}
