package com.emmanuelaguero.universidadbackend.modelo.dto;

import com.emmanuelaguero.universidadbackend.modelo.entidades.Direccion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProfesorDTO extends PersonaDTO{
    private BigDecimal sueldo;

    public ProfesorDTO(Integer id, String nombre, String apellido, @Pattern(regexp = "[0-9]+") @Size(min = 1, max = 10) String dni, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }
}
