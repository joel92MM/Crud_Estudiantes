package com.servicios.estudiantes.app.aplicacion.puertos.input;

import com.servicios.estudiantes.app.dominio.modelo.Estudiante;

import java.util.List;

public interface EstudianteServicioPuerto {

    Estudiante crearEstudiante(Estudiante estudiante);
    List<Estudiante> obtenerEstudiantes();
    Estudiante obtenerEstudiantePorId(Long id);
    Estudiante actualizarEstudiante(Long id, Estudiante estudiante);
    void eliminarEstudiante(Long id);
}
