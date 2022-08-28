package com.blogserver.authservice.filter;

import com.blogserver.authservice.service.JwtUtil;
import com.blogserver.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestToken = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if(requestToken!=null && requestToken.startsWith("Bearer ")){
            token = requestToken.substring(7);
            username = jwtUtil.extractUsername(token);
        }
        if(username!=null){
            try{
                UserDetails userDetails = userService.loadUserByUsername(username);
                if(jwtUtil.validateToken(token,userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, new ArrayList<>());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
                else
                    throw new Exception("Bad Credentials");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        filterChain.doFilter(request,response);
    }
}