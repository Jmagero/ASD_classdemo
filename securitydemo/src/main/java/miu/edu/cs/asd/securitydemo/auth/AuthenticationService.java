package miu.edu.cs.asd.securitydemo.auth;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.securitydemo.config.JwtService;
import miu.edu.cs.asd.securitydemo.repository.UserRepository;
import miu.edu.cs.asd.securitydemo.user.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        //Create User by using the data from registerRequest
        User user = new User(
                registerRequest.getUsername(),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                passwordEncoder.encode(registerRequest.getPassword()),
                registerRequest.getRole()

        );
        //Save this user
        User savedUser = userRepository.save(user);
        //Generate a token for this user
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);

    }


    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        //Attempts to authenticate  the passed Authentication object
        //Throws
        //AuthenticationException - if authentication fails
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword())
        );
//        var user = userRepository.findByUsername(authenticationRequest.getUsername())
//                .orElseThrow(() -> new UsernameNotFoundException(authenticationRequest.getUsername()));
        var user = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token  = jwtService.generateToken(user);
        return new AuthenticationResponse(token);

    }
}
