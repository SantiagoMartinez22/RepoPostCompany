package com.workshop.postal.models;
import com.workshop.postal.models.enums.TipoEmpleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Empleado extends Usuario{
    public String antiguedad;
    public String rh;
    @Enumerated(EnumType.ORDINAL)
    private TipoEmpleado tipoEmpleado;
}
