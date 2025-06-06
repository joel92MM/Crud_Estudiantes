package com.servicios.estudiantes.app.dominio.modelo;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;
}
