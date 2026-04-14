package com.tuconjuntoapp.framework.controller;

import com.tuconjuntoapp.framework.dto.AuthLoginRequest;
import com.tuconjuntoapp.framework.dto.AuthRegisterRequest;
import com.tuconjuntoapp.framework.dto.AuthResponse;
import com.tuconjuntoapp.framework.service.AuthService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registrar(@Valid @RequestBody AuthRegisterRequest request) {
        // Endpoint REST para registrar un nuevo usuario residente.
        AuthResponse response = authService.registrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthLoginRequest request) {
        // Endpoint REST para autenticar usuario y contrasena.
        AuthResponse response = authService.iniciarSesion(request);
        return ResponseEntity.ok(response);
    }
}
