package com.grokonez.jwtauthentication.Servicess;


import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.model.Utilisation;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.repository.utilisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service

public class UtilisationService {

    @Autowired
    private utilisationRepository UR;

    @Autowired
    UserService US;



    public List<Utilisation> getAllUtilisation() {return UR.findAll();
    }



    public List<Utilisation> utilClientById(long id){

        List<Utilisation> LU =null;
        User U= US.getUserById(id);
        if(U != null) {
            LU = UR.findUtilisationByIdUser(id);
        }
       return LU;
    }

    public List<Utilisation> utilClientByName(String name){

        List<Utilisation> LU =null;
        User U= US.getUserByName(name);
        if(U != null) {
            LU = UR.findUtilisationByIdUser(U.getId());
        }
        return LU;
    }


    public  List<Utilisation> utilisationDunCodeParIdCode(long idCode){
        return UR.findAllByIdCode(idCode);
    }

    public  List<Utilisation> utilisationDunCodeParTextCode(String codeText){
        return UR.findAllByCodeText(codeText);
    }


}
