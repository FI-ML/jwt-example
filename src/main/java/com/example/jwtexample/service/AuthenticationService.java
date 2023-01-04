package com.example.jwtexample.service;

import com.example.jwtexample.controller.AuthenticationRegiserRequest;
import com.example.jwtexample.controller.AuthenticationResponse;
import com.example.jwtexample.repo.UserRepository;
import com.example.jwtexample.user.Role;
import com.example.jwtexample.user.Users;
import com.example.jwtexample.validator.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse rgister(AuthenticationRegiserRequest request) {

        if (EmailValidator.isValid(request.getEmail())) {

            Users user = Users.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            repository.save(user);
            String jwtToken = jwtService.generateToken(user);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }
        return null;
    }
    public AuthenticationResponse authenticate(AuthenticationRegiserRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword())
        );
        Users user = repository.findByEmail(request.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
