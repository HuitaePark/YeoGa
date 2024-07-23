package com.travelmaker.yeoga.controller;

import com.travelmaker.yeoga.service.AuthService;
import com.travelmaker.yeoga.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yeoga")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO.getEmail(), loginDTO.getPassword());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/login/find")
    public ResponseEntity<String> findAccount(@RequestParam String email) {
        String result = authService.findAccount(email);
        return ResponseEntity.ok(result);
    }
}