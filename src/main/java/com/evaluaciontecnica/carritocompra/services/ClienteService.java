package com.evaluaciontecnica.carritocompra.services;

import com.evaluaciontecnica.carritocompra.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente save(Cliente cliente);
    List<Cliente> findAll();

}
