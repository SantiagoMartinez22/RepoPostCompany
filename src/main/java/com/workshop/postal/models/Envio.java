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

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getNombrePersonaReceptor() {
        return nombrePersonaReceptor;
    }

    public void setNombrePersonaReceptor(String nombrePersonaReceptor) {
        this.nombrePersonaReceptor = nombrePersonaReceptor;
    }

    public String getNumeroCelularReceptor() {
        return numeroCelularReceptor;
    }

    public void setNumeroCelularReceptor(String numeroCelularReceptor) {
        this.numeroCelularReceptor = numeroCelularReceptor;
    }

    public LocalDateTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalDateTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public double getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(double valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
}
