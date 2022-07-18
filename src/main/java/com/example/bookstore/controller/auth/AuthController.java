package com.example.bookstore.controller.auth;

import com.example.bookstore.domain.User;
import com.example.bookstore.security.JWTUtil;
import com.example.bookstore.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody User user) {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);

        if (userService.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account already exists.");
        }
        user = userService.save(user);
        String token = jwtUtil.generateToken(user.getEmail());

        return Collections.singletonMap("jwt-token", token);
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody User user) {
        try {
            UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
                    user.getEmail(), user.getPassword());

            authenticationManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(user.getEmail());

            return Collections.singletonMap("jwt-token", token);
        } catch (AuthenticationException ex) {
            throw new RuntimeException("Invalid Login Credentials");
        }
    }

}
