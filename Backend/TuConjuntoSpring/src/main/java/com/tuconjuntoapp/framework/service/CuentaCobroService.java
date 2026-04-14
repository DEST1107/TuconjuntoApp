package com.tuconjuntoapp.framework.service;

import com.tuconjuntoapp.framework.exception.ResourceNotFoundException;
import com.tuconjuntoapp.framework.model.CuentaCobro;
import com.tuconjuntoapp.framework.repository.CuentaCobroRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CuentaCobroService {

    private final CuentaCobroRepository cuentaCobroRepository;

    public CuentaCobroService(CuentaCobroRepository cuentaCobroRepository) {
        this.cuentaCobroRepository = cuentaCobroRepository;
    }

    public List<CuentaCobro> listar(Integer idApartamento) {
        if (idApartamento == null) {
            return cuentaCobroRepository.listarTodas();
        }
        return cuentaCobroRepository.listarPorApartamento(idApartamento);
    }

    public CuentaCobro buscarPorId(Integer idCuentaCobro) {
        return cuentaCobroRepository.buscarPorId(idCuentaCobro)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la cuenta de cobro solicitada."));
    }
}
