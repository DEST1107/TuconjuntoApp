package com.tuconjuntoapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CuentaCobroResumen {

    private int idCuentaCobro;
    private String concepto;
    private LocalDate periodo;
    private LocalDate fechaVencimiento;
    private BigDecimal valorTotal;
    private BigDecimal saldoPendiente;
    private String estado;

    public int getIdCuentaCobro() {
        return idCuentaCobro;
    }

    public void setIdCuentaCobro(int idCuentaCobro) {
        this.idCuentaCobro = idCuentaCobro;
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
}
