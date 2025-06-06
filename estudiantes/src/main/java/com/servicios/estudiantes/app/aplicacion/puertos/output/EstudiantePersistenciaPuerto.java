package com.servicios.estudiantes.app.aplicacion.puertos.output;

import com.servicios.estudiantes.app.dominio.modelo.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudiantePersistenciaPuerto {

    Estudiante crearEstudiante(Estudiante estudiante);
    List<Estudiante> obtenerEstudiantes();
    Optional<Estudiante> obtenerEstudiantePorId(Long id);
    void eliminarEstudiante(Long id);
}
