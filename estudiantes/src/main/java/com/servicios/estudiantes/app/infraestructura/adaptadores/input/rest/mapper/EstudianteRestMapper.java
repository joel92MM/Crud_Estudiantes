package com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest.mapper;

import com.servicios.estudiantes.app.dominio.modelo.Estudiante;
import com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest.model.request.EstudianteCrearRequest;
import com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest.model.response.EstudianteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstudianteRestMapper {

    Estudiante toEstudiante(EstudianteCrearRequest request);

    EstudianteResponse toEstudianteResponse(Estudiante estudiante);

    List<EstudianteResponse> toEstudianteResponseList(List<Estudiante> estudiantes);

}
