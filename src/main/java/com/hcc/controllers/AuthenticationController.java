package com.hcc.controllers;

import com.hcc.entities.AuthenticationRequest;
import com.hcc.entities.Hello;
import com.hcc.entities.User;
import com.hcc.services.HelloService;
import com.hcc.services.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

// this is an example controller feel free to delete this once you have created your own.
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationService.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );

            // If authentication is successful, load user details
            User user = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

            // Return a success response with the token or any other relevant information
            return ResponseEntity.ok("Login successful! Welcome " + userDetails.getUsername());
        } catch (UsernameNotFoundException ex) {
            // Return a failure response if user is not found
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (Exception ex) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
}
