package com.tuconjuntoapp.framework.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Incidencia {

    private Integer idIncidencia;

    @NotNull(message = "El usuario que reporta es obligatorio.")
    private Integer idUsuarioReporta;

    private Integer idApartamento;

    @NotBlank(message = "La categoria es obligatoria.")
    private String categoria;

    @NotBlank(message = "El titulo es obligatorio.")
    @Size(max = 100, message = "El titulo no debe superar 100 caracteres.")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria.")
    private String descripcion;

    @NotBlank(message = "La prioridad es obligatoria.")
    private String prioridad;

    @NotBlank(message = "El estado es obligatorio.")
    private String estado;

    @Size(max = 120, message = "La ubicacion no debe superar 120 caracteres.")
    private String ubicacion;

    private LocalDateTime fechaReporte;
    private LocalDateTime fechaCierre;

    public Integer getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Integer getIdUsuarioReporta() {
        return idUsuarioReporta;
    }

    public void setIdUsuarioReporta(Integer idUsuarioReporta) {
        this.idUsuarioReporta = idUsuarioReporta;
    }

    public Integer getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Integer idApartamento) {
        this.idApartamento = idApartamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
