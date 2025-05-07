package com.portalestagios.projeto.controller;

import com.portalestagios.projeto.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    private List<User> usuarios;

    public UserController() {
        usuarios = new ArrayList<>();
        usuarios.add(new User(1L, "joao.silva", "1234"));
        usuarios.add(new User(2L, "maria.oliveira", "senha123"));
        usuarios.add(new User(3L, "lucas.santos", "abc123"));
        usuarios.add(new User(4L, "ana.costa", "4321"));
    }

    @GetMapping
    public List<User> getUsuarios() {
        return usuarios;
    }
}