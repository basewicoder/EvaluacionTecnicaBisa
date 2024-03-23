package com.wqa.exam.domain.ports.persistence;

import com.wqa.exam.domain.data.ClienteDTO;

import java.util.List;

public interface ClientePersistencePort {
    ClienteDTO getById(Long id);

    List<ClienteDTO> findAll();

    ClienteDTO insert(ClienteDTO clienteDTO);
}
