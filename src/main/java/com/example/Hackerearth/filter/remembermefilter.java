package com.example.Hackerearth.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Hackerearth.services.jwtservice;
import com.example.Hackerearth.services.logindetailsservice;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class remembermefilter extends OncePerRequestFilter{

	 @Autowired
	    private jwtservice jwtService;

	    @Autowired
	    private logindetailsservice u;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	//	System.out.println("bbb");
		String authHeader = request.getHeader("Authorization");
		//System.out.println(authHeader);
     String token = null;
     String username = null;
     if (authHeader != null && authHeader.startsWith("bearer ")) {
    	// System.out.println("hhhel");
         token = authHeader.substring(7);
         username = jwtService.extractUsername(token);
     }

     if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
     	System.out.println("hit");
         UserDetails userDetails = u.loadUserByUsername(username);
      //   System.out.println(userDetails.getUsername()+" "+userDetails.getPassword());
         
        	 if (jwtService.validateToken(token, userDetails)) {
              	System.out.println("hit2");
                  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //  System.out.println(authToken);
                  authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                  SecurityContext k=SecurityContextHolder.getContext();
                  k.setAuthentication(authToken);
                //  System.out.println(authToken.getDetails());
                  SecurityContextHolder.setContext(k);
                  request.setAttribute("securitycontextholder", k);
              }
         
        
         
     }
	
		filterChain.doFilter(request, response);
	}	
}
