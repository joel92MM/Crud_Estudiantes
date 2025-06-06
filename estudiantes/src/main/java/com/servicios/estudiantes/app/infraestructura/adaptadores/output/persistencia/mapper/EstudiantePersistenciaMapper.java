package com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia.mapper;

import com.servicios.estudiantes.app.dominio.modelo.Estudiante;
import com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia.entidades.EstudianteEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudiantePersistenciaMapper {

    EstudianteEntidad toEstudianteEntidad(Estudiante estudiante);

    Estudiante toEstudiante(EstudianteEntidad entidad);

    List<Estudiante> toEstudiantes(List<EstudianteEntidad> entidadesLista);
}
