package com.workshop.postal.models;

import com.workshop.postal.models.enums.TipoPaquete;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private double valorDeclarado;

    @Enumerated(EnumType.ORDINAL)
    private TipoPaquete tipoPaquete;

}

