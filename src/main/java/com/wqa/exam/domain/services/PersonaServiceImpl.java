package com.wqa.exam.domain.services;

import com.wqa.exam.configuration.exception.EdadMinimaClienteException;
import com.wqa.exam.domain.data.PersonaDTO;
import com.wqa.exam.domain.ports.api.PersonaService;
import com.wqa.exam.domain.ports.persistence.PersonaPersistencePort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaPersistencePort persistencePort;

    public PersonaServiceImpl(PersonaPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    @Transactional
    public PersonaDTO getById(Long id) {
        return persistencePort.getById(id);
    }

    @Override
    public List<PersonaDTO> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public PersonaDTO insert(PersonaDTO personaDTO) {
        LocalDate fechaNacimiento = personaDTO.getFechaNacimiento();
        LocalDate fechaMinima = LocalDate.now().minusYears(20);
        if (fechaNacimiento.isAfter(fechaMinima)) {
            throw new EdadMinimaClienteException("El cliente no puede tener menos de 20 años.");
        }
        return persistencePort.insert(personaDTO);
    }
}
