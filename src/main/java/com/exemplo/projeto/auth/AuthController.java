package com.exemplo.projeto.auth;

import com.exemplo.projeto.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticação", description = "Endpoint para geração de tokens JWT")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    @Operation(summary = "Realizar login", description = "Simula a autenticação e retorna um token JWT se as credenciais forem válidas.")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequest) {
        
        // Simulação nível teste corporativo: Usuário admin e Senha 123456
        if ("admin".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())) {
            
            // Se estiver correto, gera o token usando o JwtUtil
            String token = jwtUtil.gerarToken(loginRequest.getUsername());
            
            // Retorna o token dentro de um JSON estruturado
            return ResponseEntity.ok(Map.of(
                "tipo", "Bearer",
                "token", token
            ));
        }

        // Se errar as credenciais, retorna 401 Unauthorized
        return ResponseEntity.status(401).body(Map.of("erro", "Usuário ou senha inválidos"));
    }
}