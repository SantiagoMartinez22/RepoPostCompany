package com.workshop.postal.repository;

import com.workshop.postal.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
    void deleteById(UUID id);

    Optional<Cliente> findById(UUID id);
}
