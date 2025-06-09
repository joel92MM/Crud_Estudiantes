package com.servicios.estudiantes.app.infraestructura.adaptadores.input.rest;

import com.servicios.estudiantes.app.dominio.excepciones.EstudianteNotFoundExcepcion;
import com.servicios.estudiantes.app.dominio.modelo.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.servicios.estudiantes.app.utilidades.ErrorCatalog.*;

@RestControllerAdvice
public class GlobslControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EstudianteNotFoundExcepcion.class)
    public ErrorResponse handleEstudianteFoundExcepcion() {
        return ErrorResponse.builder()
                .code(ESTUDIANTE_NOT_FOUND.getCode())
                .message(ESTUDIANTE_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        BindingResult result = ex.getBindingResult();
        return ErrorResponse.builder()
                .code(ESTUDIANTE_INVALID.getCode())
                .message(ESTUDIANTE_INVALID.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex) {
        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }



}
