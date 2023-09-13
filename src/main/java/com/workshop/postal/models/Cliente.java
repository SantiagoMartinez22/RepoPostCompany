package com.workshop.postal.models;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Cliente extends Usuario{

    @OneToMany(mappedBy = "cliente")
    private List<Envio> envios = new ArrayList<>();

}
