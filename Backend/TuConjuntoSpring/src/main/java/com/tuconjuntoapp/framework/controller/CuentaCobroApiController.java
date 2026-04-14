package com.tuconjuntoapp.framework.controller;

import com.tuconjuntoapp.framework.model.CuentaCobro;
import com.tuconjuntoapp.framework.service.CuentaCobroService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cuentas-cobro")
public class CuentaCobroApiController {

    private final CuentaCobroService cuentaCobroService;

    public CuentaCobroApiController(CuentaCobroService cuentaCobroService) {
        this.cuentaCobroService = cuentaCobroService;
    }

    @GetMapping
    public ResponseEntity<List<CuentaCobro>> listar(
            @RequestParam(value = "idApartamento", required = false) Integer idApartamento) {
        return ResponseEntity.ok(cuentaCobroService.listar(idApartamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaCobro> buscarPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(cuentaCobroService.buscarPorId(id));
    }
}
