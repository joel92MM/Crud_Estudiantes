package com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;
}
