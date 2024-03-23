package com.wqa.exam.domain.data;

import com.wqa.exam.infrastructure.entity.EstadoCliente;
import com.wqa.exam.infrastructure.entity.Persona;
import com.wqa.exam.infrastructure.entity.Referencia;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@ToString
public class ClienteDTO {

    private Long id;

    private String email;

    private String telefono;

    private String ocupacion;

    private EstadoCliente estado = EstadoCliente.CREADO;

    private PersonaDTO persona;

    private List<ReferenciaDTO> referencias ;

    private String accesibilidad;

}