package com.workshop.postal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workshop.postal.models.Empleado;

import java.util.Optional;
import java.util.UUID;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findById(UUID id);

    void deleteById(UUID id);
}
