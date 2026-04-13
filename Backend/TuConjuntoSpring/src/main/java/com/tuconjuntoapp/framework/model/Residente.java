package com.tuconjuntoapp.framework.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Residente {

    private Integer idUsuario;

    @NotBlank(message = "Los nombres son obligatorios.")
    @Size(max = 60, message = "Los nombres no deben superar 60 caracteres.")
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios.")
    @Size(max = 60, message = "Los apellidos no deben superar 60 caracteres.")
    private String apellidos;

    @NotBlank(message = "El tipo de documento es obligatorio.")
    private String tipoDocumento;

    @NotBlank(message = "El numero de documento es obligatorio.")
    @Size(max = 20, message = "El documento no debe superar 20 caracteres.")
    private String numeroDocumento;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "Debe ingresar un correo valido.")
    private String correo;

    @NotBlank(message = "La contrasena es obligatoria.")
    @Size(max = 255, message = "La contrasena no debe superar 255 caracteres.")
    private String passwordHash;

    @Size(max = 20, message = "El telefono no debe superar 20 caracteres.")
    private String telefono;

    @NotBlank(message = "El estado es obligatorio.")
    private String estado;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
