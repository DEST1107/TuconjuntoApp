package com.tuconjuntoapp.framework.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Reserva {

    private Integer idReserva;

    @NotNull(message = "El usuario de la reserva es obligatorio.")
    private Integer idUsuario;

    @NotBlank(message = "El area comun es obligatoria.")
    @Size(max = 60, message = "El area comun no debe superar 60 caracteres.")
    private String areaComun;

    @NotNull(message = "La fecha de la reserva es obligatoria.")
    @FutureOrPresent(message = "La fecha de la reserva no puede estar en el pasado.")
    private LocalDate fechaReserva;

    @NotNull(message = "La hora de la reserva es obligatoria.")
    private LocalTime horaReserva;

    @NotBlank(message = "El estado de la reserva es obligatorio.")
    private String estado;

    @Size(max = 200, message = "Las observaciones no deben superar 200 caracteres.")
    private String observaciones;

    private LocalDateTime fechaSolicitud;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAreaComun() {
        return areaComun;
    }

    public void setAreaComun(String areaComun) {
        this.areaComun = areaComun;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalTime horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
