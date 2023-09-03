package com.ntg.videogames.services;

import com.ntg.videogames.entities.User;
import com.ntg.videogames.repositories.UserRepository;
import com.ntg.videogames.utils.AuthenticationRequest;
import com.ntg.videogames.utils.AuthenticationResponse;
import com.ntg.videogames.utils.RegisterRequest;
import com.ntg.videogames.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

public AuthenticationResponse register(RegisterRequest request) {
//    boolean isRegistered = userRepository.findByEmail(request.getEmail()).isPresent();
    var user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .userName(request.getUserName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .profilePicture(request.getProfilePicture())
            .role(Role.USER)
            .build();
    userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .user(user)
            .build();
}

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(user)
                .build();
    }
}
