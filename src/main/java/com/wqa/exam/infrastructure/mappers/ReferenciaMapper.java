package com.wqa.exam.infrastructure.mappers;

import com.wqa.exam.domain.data.ReferenciaDTO;
import com.wqa.exam.infrastructure.entity.Referencia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReferenciaMapper {
    ReferenciaMapper INSTANCE = Mappers.getMapper(ReferenciaMapper.class);

    ReferenciaDTO toDTO(Referencia referencia);

    Referencia fromDTO(ReferenciaDTO referenciaDTO);

}
