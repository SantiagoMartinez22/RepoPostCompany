package com.workshop.postal.models;

import com.workshop.postal.models.enums.EstadoEnvio;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @Column(length = 10)
    private String numeroGuia;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String ciudadOrigen;

    private String ciudadDestino;

    private String direccionDestino;

    private String nombrePersonaReceptor;

    private String numeroCelularReceptor;

    private LocalDateTime horaEntrega;

    @Enumerated(EnumType.ORDINAL)
    private EstadoEnvio estadoEnvio;

    private double valorEnvio;

    @OneToOne
    @JoinColumn(name = "paquete_id")
    private Paquete paquete;

}
