package com.workshop.postal.repository;

import com.workshop.postal.models.enums.EstadoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.workshop.postal.models.Envio;

import java.util.List;

public interface EnvioRepository extends JpaRepository<Envio,String> {
    Envio findByNumeroGuia(String numeroGuia);
    List<Envio> findByEstadoEnvio(EstadoEnvio estadoEnvio);
}
