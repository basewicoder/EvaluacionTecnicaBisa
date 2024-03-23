package com.wqa.exam.domain.data;

import com.wqa.exam.infrastructure.entity.Cliente;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
public class PersonaDTO {

    private Long id;

    private String nombre;

    private String apellido;

    private LocalDate fechaNacimiento;

    private String direccion;

    private String carnetIdentidad;

}
