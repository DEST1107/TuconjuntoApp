package com.tuconjuntoapp.framework.service;

import com.tuconjuntoapp.framework.exception.ResourceNotFoundException;
import com.tuconjuntoapp.framework.model.Incidencia;
import com.tuconjuntoapp.framework.repository.IncidenciaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaService(IncidenciaRepository incidenciaRepository) {
        this.incidenciaRepository = incidenciaRepository;
    }

    public List<Incidencia> listar() {
        return incidenciaRepository.listarTodas();
    }

    public Incidencia buscarPorId(Integer idIncidencia) {
        return incidenciaRepository.buscarPorId(idIncidencia)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la incidencia solicitada."));
    }

    public Incidencia crear(Incidencia incidencia) {
        if (incidencia.getEstado() == null || incidencia.getEstado().trim().isEmpty()) {
            incidencia.setEstado("ABIERTA");
        }
        return incidenciaRepository.guardar(incidencia);
    }

    public Incidencia actualizar(Integer idIncidencia, Incidencia incidencia) {
        buscarPorId(idIncidencia);
        incidencia.setIdIncidencia(idIncidencia);
        incidenciaRepository.actualizar(incidencia);
        return buscarPorId(idIncidencia);
    }

    public void eliminar(Integer idIncidencia) {
        buscarPorId(idIncidencia);
        incidenciaRepository.eliminar(idIncidencia);
    }
}
