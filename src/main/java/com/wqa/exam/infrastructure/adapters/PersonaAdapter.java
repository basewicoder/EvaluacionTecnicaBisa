package com.wqa.exam.infrastructure.adapters;

import com.wqa.exam.domain.data.PersonaDTO;
import com.wqa.exam.domain.ports.persistence.PersonaPersistencePort;
import com.wqa.exam.infrastructure.entity.Persona;
import com.wqa.exam.infrastructure.mappers.PersonaMapper;
import com.wqa.exam.infrastructure.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public class PersonaAdapter implements PersonaPersistencePort {

    private final PersonaRepository repository;

    public PersonaAdapter(PersonaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public PersonaDTO getById(Long id) {
        log.info("data , {}", repository.findById(id).get());
        return repository.findById(id).map(PersonaMapper.INSTANCE::toDTO).orElse(null);
    }

    @Override
    public List<PersonaDTO> findAll() {
        return repository.findAll().stream().map(PersonaMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public PersonaDTO insert(PersonaDTO personaDTO) {
        Persona persona = PersonaMapper.INSTANCE.fromDTO(personaDTO);
        return PersonaMapper.INSTANCE.toDTO(repository.save(persona));
    }
}
