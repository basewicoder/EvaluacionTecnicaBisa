package com.wqa.exam.domain.services;

import com.wqa.exam.domain.data.ReferenciaDTO;
import com.wqa.exam.domain.ports.api.ReferenciaService;
import com.wqa.exam.domain.ports.persistence.ReferenciaPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {

    private final ReferenciaPersistencePort persistencePort;

    public ReferenciaServiceImpl(ReferenciaPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public ReferenciaDTO getById(Long id) {
        return persistencePort.getById(id);
    }

    @Override
    public List<ReferenciaDTO> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public ReferenciaDTO insert(ReferenciaDTO referenciaDTO) {
        referenciaDTO.setEstado("00");
        return persistencePort.insert(referenciaDTO);
    }
    @Override
    public ReferenciaDTO modificar(ReferenciaDTO referenciaDTO, String motivo) {
        referenciaDTO.setEstado("01");
        referenciaDTO.setMotivo(motivo);
        return persistencePort.insert(referenciaDTO);
    }

}
