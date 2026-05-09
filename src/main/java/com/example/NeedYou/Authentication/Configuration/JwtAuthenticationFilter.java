package com.example.NeedYou.Authentication.Configuration;

import com.example.NeedYou.Authentication.Repository.UserRepository;
import com.example.NeedYou.Authentication.Security.JwtUtil;
import com.example.NeedYou.Authentication.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader =
                request.getHeader("Authorization");

        String token = null;
        String email = null;

        // CHECK HEADER FORMAT
        if (authHeader != null &&
                authHeader.startsWith("Bearer ")) {

            // REMOVE "Bearer "
            token = authHeader.substring(7);

            // EXTRACT USERNAME FROM TOKEN
            email = jwtUtil.extractEmail(token);
        }
        if (email != null &&
                SecurityContextHolder.getContext()
                        .getAuthentication() == null) {

            Optional<User> userDetails =
                    userRepository.findByEmail(email);

            if (userDetails.isPresent()
                    && jwtUtil.validateToken(token)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails.get(),
                                null,
                                List.of(
                                        new SimpleGrantedAuthority(
                                                "ROLE_" +
                                                        userDetails.get()
                                                                .getRole()
                                                                .name()
                                        )
                                )
                        );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request));

                SecurityContextHolder.getContext()
                        .setAuthentication(authToken);
            }
        }

// ALWAYS CONTINUE FILTER CHAIN
        filterChain.doFilter(request, response);
    }
}
