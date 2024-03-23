package com.wqa.exam.infrastructure.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String telefono;
    private String ocupacion;

    @Enumerated(EnumType.STRING)
    private EstadoCliente estado = EstadoCliente.CREADO;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    private String accesibilidad;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "cliente_id", referencedColumnName = "id") })
    @Where(clause = "estado = '00'")
    private List<Referencia> referencias = new ArrayList<>();

}

/*
@OneToMany(fetch = FetchType.LAZY)
@JoinColumns({ @JoinColumn(name = "par_id_etapa", referencedColumnName = "eta_id") })
@Where(clause = "par_salida=true")
@OrderBy("par_id asc")
private List<Salida> salida;*/
