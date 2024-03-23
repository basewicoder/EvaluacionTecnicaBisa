package com.wqa.exam.domain.ports.api;

import com.wqa.exam.domain.data.PersonaDTO;

import java.util.List;

public interface PersonaService {
    PersonaDTO getById(Long id);

    List<PersonaDTO> findAll();

    PersonaDTO insert(PersonaDTO personaDTO);
}
