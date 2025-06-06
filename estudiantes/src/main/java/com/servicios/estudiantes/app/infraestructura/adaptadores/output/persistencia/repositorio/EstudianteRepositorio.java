package com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia.repositorio;

import com.servicios.estudiantes.app.dominio.modelo.Estudiante;
import com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia.entidades.EstudianteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio  extends JpaRepository<EstudianteEntidad, Long> {

}
