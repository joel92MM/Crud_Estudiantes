package com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteCrearRequest {
    @NotBlank(message = "El nombre es requerido, no puede estar vacío o nulo")
    private String nombre;

    @NotBlank(message = "El apellido es requerido, no puede estar vacío o nulo")
    private String apellido;

    @NotNull(message = "El email es requerido, no puede estar nulo")
    private String email;

    @NotBlank(message = "La edad es requerida, no puede estar vacío o nulo")
    private Integer edad;
}
