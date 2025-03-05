package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.Servicess.AchatService;
import com.grokonez.jwtauthentication.Servicess.StatService;
import com.grokonez.jwtauthentication.model.Achats;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.model.Utilisation;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//tester
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/achat")
public class AchatsRest {

  @Autowired
  private  AchatService AS;

@Autowired
  private StatService SS;

  //tester
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/getAllAchats")
  public List<Achats> getAllAchats() {
    return AS.findAllAchats();
  }


//tester
  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
  @GetMapping("/achatClientByIdUser/{id}")
  public List<Achats> ClientAchatsByIdUser(@PathVariable long id){
    return  AS.achatClientByIdUser(id);
  }

  //tester
  @PreAuthorize("hasRole('ADMIN') ")
  @GetMapping("/achatClientByIdCoupon/{id}")
  public List<Achats> ClientAchatsByIdCoupon(@PathVariable long id){
    return  AS.achatClientByIdCoupon(id);
  }

//tester
  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
  @PostMapping("/effectuerAchat/{idUser}/{idCoupon}")
  public String acherCoupon(@PathVariable long idUser,@PathVariable long idCoupon){
    return JSONParser.quote(AS.achCoupon(idUser,idCoupon));
  }


  //tester
  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
  @GetMapping("/stat/topTen")
  public List<Long> ach(){
    return SS.TopTenUsers();}


}
