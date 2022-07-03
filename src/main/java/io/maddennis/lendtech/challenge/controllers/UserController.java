package io.maddennis.lendtech.challenge.controllers;

import io.maddennis.lendtech.challenge.payload.request.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Principal", notes = "Currently logged in user")
    @GetMapping("/user")
    public ResponseEntity<String> loggedinUser(){
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(userDetails.getUsername());
    }

    @ApiOperation(value = "Account Balance", notes = "Curently logged in user account balance")
    @GetMapping("/userbalance/")
    public ResponseEntity<Double> loanBalance(@PathVariable String name){
        return ResponseEntity.ok(userService.accountBalance(name));
    }
}
