package com.tuconjuntoapp.framework.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CuentaCobro {

    private Integer idCuentaCobro;
    private Integer idApartamento;
    private Integer idConcepto;
    private String concepto;
    private LocalDate periodo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private BigDecimal valorTotal;
    private BigDecimal saldoPendiente;
    private String estado;
    private String observaciones;

    public Integer getIdCuentaCobro() {
        return idCuentaCobro;
    }

    public void setIdCuentaCobro(Integer idCuentaCobro) {
        this.idCuentaCobro = idCuentaCobro;
    }

    public Integer getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Integer idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(BigDecimal saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
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
}
