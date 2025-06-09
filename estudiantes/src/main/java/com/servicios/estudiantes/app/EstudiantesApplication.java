package com.servicios.estudiantes.app;

import com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia.entidades.EstudianteEntidad;
import com.servicios.estudiantes.app.infraestructura.adaptadores.output.persistencia.repositorio.EstudianteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EstudiantesApplication  implements CommandLineRunner {

	private final EstudianteRepositorio estudianteRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(EstudiantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<EstudianteEntidad> estudiantes = Arrays.asList(
			new EstudianteEntidad(null, "Pepe", "Perez", "pepe@pepe", 20),
			new EstudianteEntidad(null, "Juan", "Perez", "juan@pepe", 21));

		estudianteRepositorio.saveAll(estudiantes);
	}
}
