package com.tuconjuntoapp.framework.controller;

import com.tuconjuntoapp.framework.model.Noticia;
import com.tuconjuntoapp.framework.service.NoticiaService;
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
@RequestMapping("/api/noticias")
public class NoticiaApiController {

    private final NoticiaService noticiaService;

    public NoticiaApiController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public ResponseEntity<List<Noticia>> listar() {
        return ResponseEntity.ok(noticiaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> buscarPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(noticiaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Noticia> crear(@Valid @RequestBody Noticia noticia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(noticiaService.crear(noticia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> actualizar(@PathVariable("id") Integer id,
                                              @Valid @RequestBody Noticia noticia) {
        return ResponseEntity.ok(noticiaService.actualizar(id, noticia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        noticiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
