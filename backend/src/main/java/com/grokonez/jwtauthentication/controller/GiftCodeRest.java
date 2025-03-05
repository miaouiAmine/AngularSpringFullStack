package com.grokonez.jwtauthentication.controller;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grokonez.jwtauthentication.Servicess.AchatService;
import com.grokonez.jwtauthentication.Servicess.GiftCodeService;
import com.grokonez.jwtauthentication.Servicess.UtilisationService;
import com.grokonez.jwtauthentication.model.GiftCode;


import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.GiftCodeRepository;
import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.*;

//tester

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/GiftCode")
public class GiftCodeRest {

    @Autowired
    private GiftCodeService GS;

    @Autowired
    private UtilisationService US;

    @Autowired
    private AchatService AS;

    @Autowired
    private GiftCodeRepository GCR;




    //tester(get code by id long)
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/getGiftCodeById/{idCode}")
    public Optional<GiftCode> getCodeById(@PathVariable long idCode) {
        return GS.get(idCode);
    }



    //tester( get all codes)
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllGiftCodes")
    public List<GiftCode> ShowAllCodes() {
        return GS.getAllCodes();
    }




//tester
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping(path = "/utiliseGiftCode/{textCode}/{idUser}")
    public String utiliserCode(@PathVariable String textCode, @PathVariable long idUser) {
      return GS.utiliserCode(textCode, idUser);
    }



    //tester(random code generation)

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/creeGiftCode/randomCode")
    public String GenerateCode() {
        return GS.RandomCode();
    }



    //tester(get code by text string true/false)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(path = "/GiftCodeExist/{codeText}")
    public Boolean getCodeByText(@PathVariable String codeText) {
        return GS.codebytext(codeText);
    }



    //tester(test nombre utilisation avec date)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(path = "/giftCodeValable/{text}")
    public Boolean giftCodevalable(@PathVariable String text) {
        return GS.valable(text);
    }



//tester(true si il a utiliser le code et false si l utilisataeur n a pas utiliser le code)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(path = "/codeUsed/{text}/{idUser}")
    public Boolean codeUsed(@PathVariable String text, @PathVariable long idUser) {
        return GS.codeUsed(text,idUser);


    }
//tester
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/creeGiftCode")
    public String creeCode(@RequestBody GiftCode code){

        return GS.creeCode(code);
    }

//tester
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/deleteGiftCode/{idCode}")
    public String deleteCodeById(@PathVariable long idCode){

        return GS.DeleteCodeById(idCode);
    }


}
