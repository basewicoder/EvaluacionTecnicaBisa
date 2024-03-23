package com.wqa.exam.infrastructure.mappers;

import com.wqa.exam.domain.data.PersonaDTO;
import com.wqa.exam.infrastructure.entity.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDTO toDTO(Persona persona);

    Persona fromDTO(PersonaDTO personaDTO);

}
