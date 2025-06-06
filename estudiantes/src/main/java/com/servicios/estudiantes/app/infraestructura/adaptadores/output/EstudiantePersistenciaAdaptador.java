package com.servicios.estudiantes.app.infraestructura.adaptadores.output;

import com.servicios.estudiantes.app.aplicacion.puertos.output.EstudiantePersistenciaPuerto;
import com.servicios.estudiantes.app.dominio.modelo.Estudiante;

import java.util.List;
import java.util.Optional;

public class EstudiantePersistenciaAdaptador  implements EstudiantePersistenciaPuerto
{
    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return null;
    }

    @Override
    public List<Estudiante> obtenerEstudiantes() {
        return List.of();
    }

    @Override
    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void eliminarEstudiante(Long id) {

    }
}
