package com.wqa.exam.infrastructure.adapters;

import com.wqa.exam.domain.data.ClienteDTO;
import com.wqa.exam.domain.ports.persistence.ClientePersistencePort;
import com.wqa.exam.infrastructure.entity.Cliente;
import com.wqa.exam.infrastructure.mappers.ClienteMapper;
import com.wqa.exam.infrastructure.repository.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteAdapter implements ClientePersistencePort {
    private final ClienteRepository repository;

    public ClienteAdapter(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteDTO getById(Long id) {
        return repository.findById(id).map(ClienteMapper.INSTANCE::toDTO).orElse(null);
    }

    @Override
    public List<ClienteDTO> findAll() {
        return repository.findAll().stream().map(ClienteMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO insert(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.INSTANCE.fromDTO(clienteDTO);
        return ClienteMapper.INSTANCE.toDTO(repository.save(cliente));
    }
}
