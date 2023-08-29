package com.workshop.postal.models.enums;

public enum EstadoEnvio {
    RECIBIDO(0),
    EN_RUTA(1),
    ENTREGADO(2);

    private final int value;

    EstadoEnvio(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

