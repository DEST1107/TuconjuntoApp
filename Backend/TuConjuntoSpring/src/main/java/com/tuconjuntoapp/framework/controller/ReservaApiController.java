package com.tuconjuntoapp.framework.controller;

import com.tuconjuntoapp.framework.model.Reserva;
import com.tuconjuntoapp.framework.service.ReservaService;
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
@RequestMapping("/api/reservas")
public class ReservaApiController {

    private final ReservaService reservaService;

    public ReservaApiController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listar() {
        return ResponseEntity.ok(reservaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(reservaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Reserva> crear(@Valid @RequestBody Reserva reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.crear(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizar(@PathVariable("id") Integer id,
                                              @Valid @RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.actualizar(id, reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        reservaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
