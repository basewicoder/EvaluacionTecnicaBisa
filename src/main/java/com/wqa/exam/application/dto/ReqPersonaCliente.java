package com.wqa.exam.application.dto;

import com.wqa.exam.infrastructure.entity.Cliente;

import java.util.Date;

public class ReqPersonaCliente {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String direccion;
    private String carnetIdentidad;
    private Cliente clientes;
}
