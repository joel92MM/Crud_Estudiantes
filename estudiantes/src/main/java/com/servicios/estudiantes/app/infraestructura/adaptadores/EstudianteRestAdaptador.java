package com.servicios.estudiantes.app.infraestructura.adaptadores;

import com.servicios.estudiantes.app.aplicacion.puertos.input.EstudianteServicioPuerto;
import com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest.mapper.EstudianteRestMapper;
import com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest.model.request.EstudianteCrearRequest;
import com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest.model.response.EstudianteResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estudiantes")
public class EstudianteRestAdaptador {
    private final EstudianteServicioPuerto estudianteServicioPuerto;
    private final EstudianteRestMapper estudianteRestMapper;

    @GetMapping("/v1/api/estudiantes")
    public List<EstudianteResponse> obtenerEstudiantes() {
        return estudianteRestMapper.toEstudianteResponseList(estudianteServicioPuerto.obtenerEstudiantes());
    }

    @GetMapping("/v1/api/estudiantes/{id}")
    public EstudianteResponse obtenerEstudiantePorId(Long id) {
        return estudianteRestMapper.toEstudianteResponse(estudianteServicioPuerto.obtenerEstudiantePorId(id));
    }

    @PostMapping("/v1/api/estudiantes")
    public ResponseEntity<EstudianteResponse> crearEstudiante(@Valid @RequestBody EstudianteCrearRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estudianteRestMapper.toEstudianteResponse(
                        estudianteServicioPuerto.crearEstudiante(estudianteRestMapper.toEstudiante(request))));
    }
    @PutMapping("/v1/api/estudiantes/{id}")
    public EstudianteResponse actualizarEstudiante(@PathVariable Long id,
                                                   @Valid @RequestBody EstudianteCrearRequest request) {
        return estudianteRestMapper.toEstudianteResponse(
                estudianteServicioPuerto.actualizarEstudiante(id, estudianteRestMapper.toEstudiante(request)));
    }

    @DeleteMapping("/v1/api/estudiantes/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
        estudianteServicioPuerto.eliminarEstudiante(id);
    }
}
