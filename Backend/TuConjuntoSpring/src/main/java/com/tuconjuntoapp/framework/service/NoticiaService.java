package com.tuconjuntoapp.framework.service;

import com.tuconjuntoapp.framework.exception.ResourceNotFoundException;
import com.tuconjuntoapp.framework.model.Noticia;
import com.tuconjuntoapp.framework.repository.NoticiaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    private final NoticiaRepository noticiaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public List<Noticia> listar() {
        return noticiaRepository.listarTodas();
    }

    public Noticia buscarPorId(Integer idNoticia) {
        return noticiaRepository.buscarPorId(idNoticia)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la noticia solicitada."));
    }

    public Noticia crear(Noticia noticia) {
        if (noticia.getPublicada() == null) {
            noticia.setPublicada(Boolean.TRUE);
        }
        return noticiaRepository.guardar(noticia);
    }

    public Noticia actualizar(Integer idNoticia, Noticia noticia) {
        buscarPorId(idNoticia);
        noticia.setIdNoticia(idNoticia);
        noticiaRepository.actualizar(noticia);
        return buscarPorId(idNoticia);
    }

    public void eliminar(Integer idNoticia) {
        buscarPorId(idNoticia);
        noticiaRepository.eliminar(idNoticia);
    }
}
