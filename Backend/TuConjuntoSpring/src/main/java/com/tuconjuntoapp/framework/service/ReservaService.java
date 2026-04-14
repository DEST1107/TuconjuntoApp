package com.tuconjuntoapp.framework.service;

import com.tuconjuntoapp.framework.exception.ResourceNotFoundException;
import com.tuconjuntoapp.framework.model.Reserva;
import com.tuconjuntoapp.framework.repository.ReservaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> listar() {
        return reservaRepository.listarTodas();
    }

    public Reserva buscarPorId(Integer idReserva) {
        return reservaRepository.buscarPorId(idReserva)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la reserva solicitada."));
    }

    public Reserva crear(Reserva reserva) {
        if (reserva.getEstado() == null || reserva.getEstado().trim().isEmpty()) {
            reserva.setEstado("PENDIENTE");
        }
        return reservaRepository.guardar(reserva);
    }

    public Reserva actualizar(Integer idReserva, Reserva reserva) {
        buscarPorId(idReserva);
        reserva.setIdReserva(idReserva);
        reservaRepository.actualizar(reserva);
        return buscarPorId(idReserva);
    }

    public void eliminar(Integer idReserva) {
        buscarPorId(idReserva);
        reservaRepository.eliminar(idReserva);
    }
}
