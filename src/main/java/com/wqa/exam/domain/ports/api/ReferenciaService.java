package com.wqa.exam.domain.ports.api;

import com.wqa.exam.domain.data.ReferenciaDTO;

import java.util.List;

public interface ReferenciaService {
    ReferenciaDTO getById(Long id);

    List<ReferenciaDTO> findAll();

    ReferenciaDTO insert(ReferenciaDTO referenciaDTO);

    ReferenciaDTO modificar(ReferenciaDTO referenciaDTO,String motivo);
}
