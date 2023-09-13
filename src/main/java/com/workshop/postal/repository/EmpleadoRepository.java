package com.workshop.postal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workshop.postal.models.Empleado;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findById(Long id);

    void deleteById(Long id);
}
