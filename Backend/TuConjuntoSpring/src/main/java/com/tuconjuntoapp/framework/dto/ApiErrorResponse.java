package com.tuconjuntoapp.framework.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ApiErrorResponse {

    private final LocalDateTime fecha;
    private final String mensaje;
    private final List<String> errores;

    public ApiErrorResponse(String mensaje, List<String> errores) {
        this.fecha = LocalDateTime.now();
        this.mensaje = mensaje;
        this.errores = errores;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public List<String> getErrores() {
        return errores;
    }
}
