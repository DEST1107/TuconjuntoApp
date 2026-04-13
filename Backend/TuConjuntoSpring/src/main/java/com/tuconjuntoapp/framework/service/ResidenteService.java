package com.tuconjuntoapp.framework.service;

import com.tuconjuntoapp.framework.model.Residente;
import com.tuconjuntoapp.framework.repository.ResidenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ResidenteService {

    private final ResidenteRepository residenteRepository;

    public ResidenteService(ResidenteRepository residenteRepository) {
        this.residenteRepository = residenteRepository;
    }

    public List<Residente> listar(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            return residenteRepository.listarTodos();
        }
        return residenteRepository.buscarPorCorreo(correo.trim());
    }

    public Optional<Residente> buscarPorId(Integer idUsuario) {
        return residenteRepository.buscarPorId(idUsuario);
    }

    // Centraliza la decision entre crear o actualizar para mantener simple el controlador.
    public void guardar(Residente residente) {
        if (residente.getIdUsuario() == null) {
            if (residente.getEstado() == null || residente.getEstado().trim().isEmpty()) {
                residente.setEstado("ACTIVO");
            }
            residenteRepository.guardar(residente);
            return;
        }
        residenteRepository.actualizar(residente);
    }

    public void eliminar(Integer idUsuario) {
        residenteRepository.eliminar(idUsuario);
    }
}
