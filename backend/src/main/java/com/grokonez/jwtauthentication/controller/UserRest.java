package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.Servicess.UserService;
import com.grokonez.jwtauthentication.model.User;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//tester
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/User")
public class UserRest {

@Autowired
    UserService US;


//tester
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(path = "/UserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return US.getUserByName(name);
    }
//tester
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(path = "/UserById/{id}")
    public User getUserByName(@PathVariable long id) {
        return US.getUserById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/AllUsers")
    public List<User> getUserByName() {
        return US.allUser();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path = "/UserIdFromName/{name}")
    public long getIdByName(@PathVariable String name) {
        return US.getIdFromName(name);
    }

}
