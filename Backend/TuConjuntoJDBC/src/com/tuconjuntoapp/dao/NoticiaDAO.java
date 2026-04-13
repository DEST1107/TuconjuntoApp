package com.tuconjuntoapp.dao;

import com.tuconjuntoapp.config.ConexionDB;
import com.tuconjuntoapp.model.Noticia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NoticiaDAO {

    private static final String SQL_LISTAR_PUBLICADAS =
            "SELECT id_noticia, id_usuario_autor, titulo, contenido, "
                    + "fecha_publicacion, prioridad, publicada "
                    + "FROM noticias "
                    + "WHERE publicada = TRUE "
                    + "ORDER BY fecha_publicacion DESC";

    public List<Noticia> listarPublicadas() {
        List<Noticia> noticias = new ArrayList<>();

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(SQL_LISTAR_PUBLICADAS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                noticias.add(mapearNoticia(rs));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No fue posible listar las noticias publicadas", e);
        }

        return noticias;
    }

    private Noticia mapearNoticia(ResultSet rs) throws SQLException {
        Noticia noticia = new Noticia();
        noticia.setIdNoticia(rs.getInt("id_noticia"));
        noticia.setIdUsuarioAutor(rs.getInt("id_usuario_autor"));
        noticia.setTitulo(rs.getString("titulo"));
        noticia.setContenido(rs.getString("contenido"));

        Timestamp fecha = rs.getTimestamp("fecha_publicacion");
        if (fecha != null) {
            noticia.setFechaPublicacion(fecha.toLocalDateTime());
        }

        noticia.setPrioridad(rs.getString("prioridad"));
        noticia.setPublicada(rs.getBoolean("publicada"));
        return noticia;
    }
}
