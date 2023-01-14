package com.evaluaciontecnica.carritocompra.repository;

import com.evaluaciontecnica.carritocompra.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends CrudRepository<Cliente, Integer> {



}
