package com.workshop.postal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workshop.postal.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
