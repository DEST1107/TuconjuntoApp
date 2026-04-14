package com.tuconjuntoapp.framework.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Noticia {

    private Integer idNoticia;

    @NotNull(message = "El autor de la noticia es obligatorio.")
    private Integer idUsuarioAutor;

    @NotBlank(message = "El titulo es obligatorio.")
    @Size(max = 120, message = "El titulo no debe superar 120 caracteres.")
    private String titulo;

    @NotBlank(message = "El contenido es obligatorio.")
    private String contenido;

    private LocalDateTime fechaPublicacion;
    private LocalDateTime fechaExpiracion;

    @NotBlank(message = "La prioridad es obligatoria.")
    private String prioridad;

    @NotNull(message = "Debe indicar si la noticia esta publicada.")
    private Boolean publicada;

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Integer getIdUsuarioAutor() {
        return idUsuarioAutor;
    }

    public void setIdUsuarioAutor(Integer idUsuarioAutor) {
        this.idUsuarioAutor = idUsuarioAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Boolean getPublicada() {
        return publicada;
    }

    public void setPublicada(Boolean publicada) {
        this.publicada = publicada;
    }
}
