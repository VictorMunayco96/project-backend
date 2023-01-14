package com.evaluaciontecnica.carritocompra.services.impl;

import com.evaluaciontecnica.carritocompra.entity.Cliente;
import com.evaluaciontecnica.carritocompra.repository.ClienteRepository;
import com.evaluaciontecnica.carritocompra.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }
}
