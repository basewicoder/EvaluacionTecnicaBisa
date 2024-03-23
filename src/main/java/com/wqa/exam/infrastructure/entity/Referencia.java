package com.wqa.exam.infrastructure.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_referencia")
public class Referencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motivo;

    @Column(name = "cliente_id")
    private Integer clienteID;

    @Column(name = "estado")
    private String estado;
}
//@ManyToOne
  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;*/
