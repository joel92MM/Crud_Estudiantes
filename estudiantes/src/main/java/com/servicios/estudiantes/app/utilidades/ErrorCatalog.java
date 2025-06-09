package com.servicios.estudiantes.app.utilidades;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    ESTUDIANTE_NOT_FOUND("ERR_ESTUDIANTE_001", "Estudiante no encontrado"),
    ESTUDIANTE_INVALID("ERR_ESTUDIANTE_002", "Estudiante inválido"),
    GENERIC_ERROR("ERR_001", "Ocurrió un error genérico");
    private String code;
    private String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
