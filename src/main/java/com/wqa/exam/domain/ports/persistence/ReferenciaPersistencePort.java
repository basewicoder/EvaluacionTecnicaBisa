package com.wqa.exam.domain.ports.persistence;

import com.wqa.exam.domain.data.ReferenciaDTO;

import java.util.List;

public interface ReferenciaPersistencePort {
    ReferenciaDTO getById(Long id);

    List<ReferenciaDTO> findAll();

    ReferenciaDTO insert(ReferenciaDTO referenciaDTO);
}
