package com.tuconjuntoapp.framework.controller;

import com.tuconjuntoapp.framework.model.Incidencia;
import com.tuconjuntoapp.framework.service.IncidenciaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaApiController {

    private final IncidenciaService incidenciaService;

    public IncidenciaApiController(IncidenciaService incidenciaService) {
        this.incidenciaService = incidenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Incidencia>> listar() {
        return ResponseEntity.ok(incidenciaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> buscarPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(incidenciaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Incidencia> crear(@Valid @RequestBody Incidencia incidencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(incidenciaService.crear(incidencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidencia> actualizar(@PathVariable("id") Integer id,
                                                 @Valid @RequestBody Incidencia incidencia) {
        return ResponseEntity.ok(incidenciaService.actualizar(id, incidencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        incidenciaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
