package com.tuconjuntoapp.framework.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthLoginRequest {

    @NotBlank(message = "El usuario es obligatorio.")
    @Email(message = "El usuario debe tener formato de correo electronico.")
    private String usuario;

    @NotBlank(message = "La contrasena es obligatoria.")
    @Size(min = 4, max = 60, message = "La contrasena debe tener entre 4 y 60 caracteres.")
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
