package com.example.Hackerearth.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Hackerearth.enums.Roles;
import com.example.Hackerearth.services.Jwtservice;
import com.example.Hackerearth.services.Logindetailsservice;
import com.example.Hackerearth.dto.Logindetailsdto;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Remembermefilter extends OncePerRequestFilter{

	 private static final String ROLE_ANONOMOUS = null;

	 @Autowired
	 private Jwtservice jwtService;

	 @Autowired
	 private Logindetailsservice u;
	 
	 @Override
	 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	 String authHeader = request.getHeader("Authorization");
     String token = null;
     String username = null;
     if (authHeader != null && authHeader.startsWith("Bearer ")) {
         token = authHeader.substring(7);
         username = jwtService.extractUsername(token);
     }
     if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
     	System.out.println("hit");
         UserDetails userDetails = u.loadUserByUsername(username);
        	 if (jwtService.validateToken(token, userDetails)) {
              	System.out.println("hit2");
                  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                  System.out.println(authToken);
                  authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                  SecurityContext k=SecurityContextHolder.getContext();
                  k.setAuthentication(authToken);
                  System.out.println(authToken.getDetails());
                  SecurityContextHolder.setContext(k);
                  request.setAttribute("securitycontextholder", k);
              }   
     }
	 filterChain.doFilter(request, response);
	 System.out.println("----------bye-----------");
	}	
}
