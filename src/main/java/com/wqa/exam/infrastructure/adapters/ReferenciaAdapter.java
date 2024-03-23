package com.wqa.exam.infrastructure.adapters;

import com.wqa.exam.domain.data.ReferenciaDTO;
import com.wqa.exam.domain.ports.persistence.ReferenciaPersistencePort;
import com.wqa.exam.infrastructure.entity.Referencia;
import com.wqa.exam.infrastructure.mappers.ReferenciaMapper;
import com.wqa.exam.infrastructure.repository.ReferenciaRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ReferenciaAdapter implements ReferenciaPersistencePort {

    private final ReferenciaRepository repository;

    public ReferenciaAdapter(ReferenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReferenciaDTO getById(Long id) {
        return repository.findById(id).map(ReferenciaMapper.INSTANCE::toDTO).orElse(null);
    }

    @Override
    public List<ReferenciaDTO> findAll() {
        return repository.findAll().stream().map(ReferenciaMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public ReferenciaDTO insert(ReferenciaDTO referenciaDTO) {
        Referencia referencia = ReferenciaMapper.INSTANCE.fromDTO(referenciaDTO);
        referencia = repository.save(referencia);
        return ReferenciaMapper.INSTANCE.toDTO(referencia);
    }
}
