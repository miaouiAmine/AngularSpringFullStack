package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.Servicess.UtilisationService;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.model.Utilisation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


//tester
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/Utilisation")
public class UtilisationRest {
    @Autowired
    UtilisationService US;



//tester
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllUtilisation")
    public List<Utilisation> getAllUtilisation() {
        return US.getAllUtilisation();
    }

//tester
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/utilisationClientById/{id}")
    public List<Utilisation> ClientUtilisationById(@PathVariable long id){
        return  US.utilClientById(id);
    }


    //tester
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/utilisationClientByName/{name}")
    public List<Utilisation> ClientUtilisationByName(@PathVariable String name){
        return  US.utilClientByName(name);
    }

//tester
    @PreAuthorize("hasRole('ADMIN') ")
    @GetMapping("/utilisationCodeIdCode/{idCode}")
    public List<Utilisation> utilisationDunCodeParIdCode(@PathVariable long idCode){
        return US.utilisationDunCodeParIdCode(idCode);
    }

//tester
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/utilisationCodeTextCode/{text}")
    public List<Utilisation> utilisationDunCodeParTextCode(@PathVariable String text){
        return US.utilisationDunCodeParTextCode(text);
    }

}





