package com.wqa.exam.infrastructure.mappers;

import com.wqa.exam.domain.data.ClienteDTO;
import com.wqa.exam.infrastructure.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper  {
    ClienteMapper  INSTANCE = Mappers.getMapper(ClienteMapper.class);
    ClienteDTO toDTO(Cliente cliente);
    Cliente fromDTO(ClienteDTO clienteDTO);

}
