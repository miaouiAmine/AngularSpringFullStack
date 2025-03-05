package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.Servicess.PortMonnaisService;


import com.grokonez.jwtauthentication.model.PortMonnais;
import jdk.nashorn.internal.parser.JSONParser;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/portMonais")
public class PortMonnaisRest {

    @Autowired
    private PortMonnaisService PS;


    //tester return solde from user id return -1 si portmonnais no trouver
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("getSolde/{idUser}")
    public int getusersold(@PathVariable long idUser) {
        return PS.getusersold(idUser);
    }



    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("getSoldeById/{idUser}")
    public String getSoldeByIdUser(@PathVariable long idUser) {
        return JSONParser.quote(PS.getSoldeByIdUser(idUser));
    }




    //tester all portmonnais
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("getAllPortm")
    public List<PortMonnais> getAllPortm() {
        return PS.findAll();
    }


    //tester delete portmonnais
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("deletByid/{idPort}")
    public String deleteById(@PathVariable long idPort) {
         return PS.deleteByidPort(idPort);

    }

    //tester
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("UpdateSold/{iduser}/{ajout}")
    public String UpdateById(@PathVariable long iduser, @PathVariable int ajout) {
        return PS.updateSolde(iduser, ajout);

    }
//tester
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/CreePort/{idUser}")
    public String creePortPourUser(@PathVariable long idUser) {
        return JSONParser.quote(PS.creePort(idUser));

    }
//tester
   @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deletPortByUserId/{idUser}")
    public String deletePortByUserId(@PathVariable long idUser) {
        return PS.deletePortByUserId(idUser);

    }
//tester
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/bloquerPort/{idUser}")
   public String bloquerPortUser(@PathVariable long idUser){
        return JSONParser.quote(PS.bloquerPortUser(idUser));
    }
//tester
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/activerPort/{idUser}")
    public String activerPortUser(@PathVariable long idUser){
        return JSONParser.quote(PS.activerPortUser(idUser));
    }


}
