package com.tuconjuntoapp.framework.service;

import com.tuconjuntoapp.framework.dto.AuthLoginRequest;
import com.tuconjuntoapp.framework.dto.AuthRegisterRequest;
import com.tuconjuntoapp.framework.dto.AuthResponse;
import com.tuconjuntoapp.framework.exception.AuthenticationFailedException;
import com.tuconjuntoapp.framework.model.UsuarioAuth;
import com.tuconjuntoapp.framework.repository.AuthRepository;
import com.tuconjuntoapp.framework.util.PasswordEncoderUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public AuthResponse registrar(AuthRegisterRequest request) {
        if (authRepository.existeCorreo(request.getUsuario())) {
            throw new IllegalArgumentException("El usuario ya se encuentra registrado.");
        }

        if (authRepository.existeDocumento(request.getNumeroDocumento())) {
            throw new IllegalArgumentException("El numero de documento ya existe en el sistema.");
        }

        // La contrasena se transforma antes de guardar para no almacenar texto plano.
        String passwordHash = PasswordEncoderUtil.encode(request.getPassword());
        Integer idGenerado = authRepository.registrar(request, passwordHash);

        return new AuthResponse(
                true,
                "Registro satisfactorio.",
                request.getUsuario(),
                idGenerado
        );
    }

    public AuthResponse iniciarSesion(AuthLoginRequest request) {
        UsuarioAuth usuario = authRepository.buscarPorCorreo(request.getUsuario())
                .orElseThrow(() -> new AuthenticationFailedException("Error en la autenticacion."));

        if (!"ACTIVO".equalsIgnoreCase(usuario.getEstado())) {
            throw new AuthenticationFailedException("Error en la autenticacion.");
        }

        if (!PasswordEncoderUtil.matches(request.getPassword(), usuario.getPasswordHash())) {
            throw new AuthenticationFailedException("Error en la autenticacion.");
        }

        return new AuthResponse(
                true,
                "Autenticacion satisfactoria.",
                usuario.getCorreo(),
                usuario.getIdUsuario()
        );
    }
}
