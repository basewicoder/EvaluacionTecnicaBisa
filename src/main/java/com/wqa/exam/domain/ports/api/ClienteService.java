package com.wqa.exam.domain.ports.api;

import com.wqa.exam.domain.data.ClienteDTO;
import com.wqa.exam.domain.data.ReferenciaDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO actualizar(ClienteDTO cliente);

    ClienteDTO getById(Long id);

    List<ClienteDTO> findAll();

    List<ClienteDTO> accesibilidadCliente();

    ClienteDTO insert(ClienteDTO clienteDTO);

    ClienteDTO insertClientePersona(ClienteDTO clienteDTO);
}
