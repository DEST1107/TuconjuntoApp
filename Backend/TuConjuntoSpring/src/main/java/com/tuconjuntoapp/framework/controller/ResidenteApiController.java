package com.tuconjuntoapp.framework.controller;

import com.tuconjuntoapp.framework.exception.ResourceNotFoundException;
import com.tuconjuntoapp.framework.model.Residente;
import com.tuconjuntoapp.framework.service.ResidenteService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/residentes")
public class ResidenteApiController {

    private final ResidenteService residenteService;

    public ResidenteApiController(ResidenteService residenteService) {
        this.residenteService = residenteService;
    }

    @GetMapping
    public ResponseEntity<List<Residente>> listar(@RequestParam(value = "correo", required = false) String correo) {
        return ResponseEntity.ok(residenteService.listar(correo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Residente> buscarPorId(@PathVariable("id") Integer id) {
        Residente residente = residenteService.buscarPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el residente solicitado."));
        return ResponseEntity.ok(residente);
    }

    @PostMapping
    public ResponseEntity<Residente> crear(@Valid @RequestBody Residente residente) {
        residente.setIdUsuario(null);
        residenteService.guardar(residente);
        return ResponseEntity.status(HttpStatus.CREATED).body(residente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Residente> actualizar(@PathVariable("id") Integer id,
                                                @Valid @RequestBody Residente residente) {
        residente.setIdUsuario(id);
        residenteService.guardar(residente);
        Residente actualizado = residenteService.buscarPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el residente solicitado."));
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        residenteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
