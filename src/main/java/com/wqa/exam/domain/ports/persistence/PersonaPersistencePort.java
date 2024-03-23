package com.wqa.exam.domain.ports.persistence;

import com.wqa.exam.domain.data.PersonaDTO;

import java.util.List;

public interface PersonaPersistencePort {
    PersonaDTO getById(Long id);

    List<PersonaDTO> findAll();

    PersonaDTO insert(PersonaDTO personaDTO);
}
