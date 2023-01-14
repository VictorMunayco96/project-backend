package com.evaluaciontecnica.carritocompra.repository;

import com.evaluaciontecnica.carritocompra.entity.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Integer> {



}
