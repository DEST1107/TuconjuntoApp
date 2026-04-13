package com.tuconjuntoapp;

import com.tuconjuntoapp.dao.UsuarioDAO;
import com.tuconjuntoapp.model.Usuario;

public class TestInsert {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(
                "Nazar Daniel",
                "Solarte",
                "CC",
                "1000000000",
                "nazar@example.com",
                "1234",
                "3000000000",
                "ACTIVO"
        );

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean insertado = usuarioDAO.registrarResidente(usuario);

        if (insertado) {
            System.out.println("Residente registrado correctamente con id: " + usuario.getIdUsuario());
        }
    }
}
