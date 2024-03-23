package com.wqa.exam.domain.data;

import com.wqa.exam.infrastructure.entity.Cliente;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
public class ReferenciaDTO {

    private Long id;

    private String motivo;

    private Integer clienteID;

    private String estado;
}
