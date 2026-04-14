package com.tuconjuntoapp.framework.dto;

public class AuthResponse {

    private boolean autenticado;
    private String mensaje;
    private String usuario;
    private Integer idUsuario;

    public AuthResponse(boolean autenticado, String mensaje, String usuario, Integer idUsuario) {
        this.autenticado = autenticado;
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.idUsuario = idUsuario;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }
}
