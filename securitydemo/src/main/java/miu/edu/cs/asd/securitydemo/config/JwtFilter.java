package miu.edu.cs.asd.securitydemo.config;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.securitydemo.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter  extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //verify the request has authorization header
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token  = authHeader.substring(7);
            Claims claims = jwtService.getClaimsFromToken(token);
            // from claims, extract the username
            String username = claims.getSubject();
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //check whether user exists in DB
                var user =   userRepository.findByUsername(username).orElseThrow( ()
                        -> new UsernameNotFoundException("user not found")
                );
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                user, null, user.getAuthorities());
                // Set Authentication object in Security Context(
                SecurityContextHolder.getContext()
                        .setAuthentication(
                                authenticationToken
                               );
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().contains("/api/v1/auth");
    }
}
