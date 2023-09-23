package com.workshop.postal;

public class CrearEnvioRequest {

    private Long cedulaCliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String nombreRecibe;
    private String celular;
    private double valorDeclaradoPaquete;
    private double peso;

    // Agregar getters y setters

    public Long getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Long cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
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

    public String getNombreRecibe() {
        return nombreRecibe;
    }

    public void setNombreRecibe(String nombreRecibe) {
        this.nombreRecibe = nombreRecibe;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public double getValorDeclaradoPaquete() {
        return valorDeclaradoPaquete;
    }

    public void setValorDeclaradoPaquete(double valorDeclaradoPaquete) {
        this.valorDeclaradoPaquete = valorDeclaradoPaquete;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}

