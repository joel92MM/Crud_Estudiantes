package com.servicios.estudiantes.app.aplicacion.servicio;

import com.servicios.estudiantes.app.aplicacion.puertos.input.EstudianteServicioPuerto;
import com.servicios.estudiantes.app.aplicacion.puertos.output.EstudiantePersistenciaPuerto;
import com.servicios.estudiantes.app.dominio.excepciones.EstudianteNotFoundExcepcion;
import com.servicios.estudiantes.app.dominio.modelo.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServicioEstudiante  implements EstudianteServicioPuerto {

    private final EstudiantePersistenciaPuerto estudiantePersistenciaPuerto;


    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudiantePersistenciaPuerto.crearEstudiante(estudiante);

    }

    @Override
    public List<Estudiante> obtenerEstudiantes() {
        return estudiantePersistenciaPuerto.obtenerEstudiantes();
    }

    @Override
    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudiantePersistenciaPuerto.obtenerEstudiantePorId(id)
                .orElseThrow(EstudianteNotFoundExcepcion::new);
    }

    @Override
    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
        return estudiantePersistenciaPuerto.obtenerEstudiantePorId(id)
                .map(guardarEstudiante ->
                {
                    guardarEstudiante.setNombre(estudiante.getNombre());
                    guardarEstudiante.setApellido(estudiante.getApellido());
                    guardarEstudiante.setEmail(estudiante.getEmail());
                    guardarEstudiante.setEdad(estudiante.getEdad());
                    return estudiantePersistenciaPuerto.crearEstudiante(guardarEstudiante);
                })
                .orElseThrow(EstudianteNotFoundExcepcion::new);
    }

    @Override
    public void eliminarEstudiante(Long id) {

        if (estudiantePersistenciaPuerto.obtenerEstudiantePorId(id).isEmpty()) {
            throw new EstudianteNotFoundExcepcion();
        }
        estudiantePersistenciaPuerto.eliminarEstudiante(id);
    }
}
