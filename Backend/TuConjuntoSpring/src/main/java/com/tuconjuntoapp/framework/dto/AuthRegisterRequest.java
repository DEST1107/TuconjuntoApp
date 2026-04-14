package com.tuconjuntoapp.framework.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthRegisterRequest {

    @NotBlank(message = "El usuario es obligatorio.")
    @Email(message = "El usuario debe tener formato de correo electronico.")
    private String usuario;

    @NotBlank(message = "La contrasena es obligatoria.")
    @Size(min = 4, max = 60, message = "La contrasena debe tener entre 4 y 60 caracteres.")
    private String password;

    @NotBlank(message = "Los nombres son obligatorios.")
    @Size(max = 60, message = "Los nombres no deben superar 60 caracteres.")
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios.")
    @Size(max = 60, message = "Los apellidos no deben superar 60 caracteres.")
    private String apellidos;

    @NotBlank(message = "El tipo de documento es obligatorio.")
    private String tipoDocumento;

    @NotBlank(message = "El numero de documento es obligatorio.")
    @Size(max = 20, message = "El numero de documento no debe superar 20 caracteres.")
    private String numeroDocumento;

    @Size(max = 20, message = "El telefono no debe superar 20 caracteres.")
    private String telefono;

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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
