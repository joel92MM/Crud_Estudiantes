package com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia;

import com.servicios.estudiantes.app.aplicacion.puertos.output.EstudiantePersistenciaPuerto;
import com.servicios.estudiantes.app.dominio.modelo.Estudiante;
import com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia.mapper.EstudiantePersistenciaMapper;
import com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia.repositorio.EstudianteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class EstudiantePersistenciaAdaptador  implements EstudiantePersistenciaPuerto {

    private final EstudianteRepositorio estudianteRepositorio;
    private final EstudiantePersistenciaMapper estudiantePersistenciaMapper;

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudiantePersistenciaMapper.toEstudiante(
                estudianteRepositorio.save(estudiantePersistenciaMapper.toEstudianteEntidad(estudiante)));
    }

    @Override
    public List<Estudiante> obtenerEstudiantes() {
        return estudiantePersistenciaMapper.toEstudiantes(estudianteRepositorio.findAll());
    }

    @Override
    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return estudianteRepositorio.findById(id)
                .map(estudiantePersistenciaMapper::toEstudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepositorio.deleteById(id);
    }
}
