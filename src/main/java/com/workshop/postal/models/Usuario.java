package com.workshop.postal.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    public String cedula;
    public String nombre;
    public String apellidos;
    public String celular;
    public String correo;
    public String direccion;
    public String ciudad;
}
