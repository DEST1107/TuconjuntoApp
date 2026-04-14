package com.tuconjuntoapp.framework.repository;

import com.tuconjuntoapp.framework.model.Noticia;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class NoticiaRepository {

    private static final String SQL_LISTAR =
            "SELECT id_noticia, id_usuario_autor, titulo, contenido, fecha_publicacion, "
                    + "fecha_expiracion, prioridad, publicada FROM noticias ORDER BY fecha_publicacion DESC";

    private static final String SQL_BUSCAR_POR_ID =
            "SELECT id_noticia, id_usuario_autor, titulo, contenido, fecha_publicacion, "
                    + "fecha_expiracion, prioridad, publicada FROM noticias WHERE id_noticia = ?";

    private static final String SQL_INSERTAR =
            "INSERT INTO noticias (id_usuario_autor, titulo, contenido, fecha_publicacion, "
                    + "fecha_expiracion, prioridad, publicada) VALUES (?, ?, ?, NOW(), ?, ?, ?)";

    private static final String SQL_ACTUALIZAR =
            "UPDATE noticias SET id_usuario_autor = ?, titulo = ?, contenido = ?, fecha_expiracion = ?, "
                    + "prioridad = ?, publicada = ? WHERE id_noticia = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM noticias WHERE id_noticia = ?";

    private final JdbcTemplate jdbcTemplate;

    public NoticiaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Noticia> listarTodas() {
        return jdbcTemplate.query(SQL_LISTAR, rowMapper());
    }

    public Optional<Noticia> buscarPorId(Integer idNoticia) {
        List<Noticia> resultados = jdbcTemplate.query(SQL_BUSCAR_POR_ID, rowMapper(), idNoticia);
        return resultados.stream().findFirst();
    }

    public Noticia guardar(Noticia noticia) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, noticia.getIdUsuarioAutor());
            preparedStatement.setString(2, noticia.getTitulo());
            preparedStatement.setString(3, noticia.getContenido());
            preparedStatement.setObject(4, noticia.getFechaExpiracion());
            preparedStatement.setString(5, noticia.getPrioridad());
            preparedStatement.setBoolean(6, noticia.getPublicada());
            return preparedStatement;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            noticia.setIdNoticia(keyHolder.getKey().intValue());
        }
        return noticia;
    }

    public boolean actualizar(Noticia noticia) {
        int filas = jdbcTemplate.update(
                SQL_ACTUALIZAR,
                noticia.getIdUsuarioAutor(),
                noticia.getTitulo(),
                noticia.getContenido(),
                noticia.getFechaExpiracion(),
                noticia.getPrioridad(),
                noticia.getPublicada(),
                noticia.getIdNoticia()
        );
        return filas > 0;
    }

    public boolean eliminar(Integer idNoticia) {
        return jdbcTemplate.update(SQL_ELIMINAR, idNoticia) > 0;
    }

    private BeanPropertyRowMapper<Noticia> rowMapper() {
        return new BeanPropertyRowMapper<Noticia>(Noticia.class);
    }
}
