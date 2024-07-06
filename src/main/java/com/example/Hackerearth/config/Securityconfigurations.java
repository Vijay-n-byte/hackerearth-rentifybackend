package com.example.Hackerearth.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.web.cors.CorsConfigurationSource;

import com.example.Hackerearth.filter.Remembermefilter;
import com.example.Hackerearth.services.Logindetailsservice;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class Securityconfigurations {

	@Autowired
	private Remembermefilter rmf;
	
	@Bean
	public UserDetailsService getuserdetails1() {
		return new Logindetailsservice();
	}
 
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	return http.csrf((e)->e.disable())
		//	.cors((n)->n.disable())
			.cors(Customizer.withDefaults())
			.sessionManagement(n->n.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(
				n->
				      n.requestMatchers("/rentify/**").permitAll()
				      .requestMatchers("/seller/**").hasRole("SELLER")
				      .requestMatchers("/buyer/**").hasRole("BUYER")
				)
		     .authenticationProvider(getauthenticationprovider())
		     .securityContext((m)->
		    	 m.securityContextRepository(new RequestAttributeSecurityContextRepository("securitycontextholder"))
		    	 )
		     .addFilterBefore(rmf, UsernamePasswordAuthenticationFilter.class)
		 //    .addFilterBefore(corsFilter(), ChannelProcessingFilter.class)
		     .build();
    }
	
	@Bean
    public PasswordEncoder getpasswordencorder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public AuthenticationProvider getauthenticationprovider() {
		DaoAuthenticationProvider d=new DaoAuthenticationProvider();
		d.setUserDetailsService(getuserdetails1());
		d.setPasswordEncoder(getpasswordencorder());
		return d;
	}
	
	@Bean
	public AuthenticationManager getauthenticationmanager(AuthenticationConfiguration c) throws Exception {
		return c.getAuthenticationManager();
	}
	@Bean
	public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source =
	            new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.addAllowedOrigin("http://192.168.43.122:4200");
	//    config.addAllowedOrigin("http://ec2-54-89-222-88.compute-1.amazonaws.com:4200");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("OPTIONS");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("PUT");
	    config.addAllowedMethod("DELETE");
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
}
