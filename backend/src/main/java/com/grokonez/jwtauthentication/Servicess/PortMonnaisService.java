package com.grokonez.jwtauthentication.Servicess;


import com.grokonez.jwtauthentication.model.PortMonnais;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.PortMonnaisRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortMonnaisService {

    @Autowired
    private UserRepository UR;
    @Autowired
    private PortMonnaisRepository PR;


    public Optional<PortMonnais> findById(long idPortMonnais) {
        return PR.findById(idPortMonnais);
    }

    //tester
    public List<PortMonnais> findAll() {
        return PR.findAll();
    }

    //tester
    public String deleteByidPort(long id) {
        int i = 0;
        List<PortMonnais> LP = PR.findAll();
        for (PortMonnais p : LP) {
            if (p.getIdPortMonnais() == id) i++;
        }
        if (i == 0) return "il n y a pas un portMonnais dont ID = " + id;
        else
            PR.deleteById(id);
        return "PortMonnais dont l ID = " + id + " a ete supprimer avec sucsess";

    }

    //tester
    public int getusersold(long iduser) {
        List<PortMonnais> LP = PR.findAll();
        for (PortMonnais p : LP) {
            if (p.getIdUser() == iduser)
                return p.getSolde();
        }
        return -1;

    }

    //tester
    public String updateSolde(long idUser, int x) {


        PortMonnais P = PR.findPortMonnaisByIdUser(idUser);
        if(P==null) return "utilisateur inexistant";
        if(x<0) return "solde ne peut pas etre negative";
        if(P.getEtat().charAt(0)=='B' || P.getEtat().charAt(0)=='b') return "portMonnais bloquer";
       P.setSolde(x);
       PR.save(P);
return "solde = "+x;
    }

    //tester
    public String creePort(long idUser) {
        int s;
        User U = UR.findUserById(idUser);
        if (U == null) {
            return "utilisateur inexistant";
        } else {

            int solde;
            solde = getusersold(idUser);
            if (solde == -1) {


                PortMonnais P = new PortMonnais();
                P.setSolde(0);
                P.setIdUser(UR.findUserById(idUser).getId());
                P.setEtat("A");
                PR.save(P);
                return "Votre PortMnnaois est activer avec sucsess , voter solde  = 0";
            } else {
                s = getusersold(idUser);
                return "vous avez deja un port monnais ,votre solde = " + s;
            }

        }

    }

    public String deletePortByUserId(long id) {
        User U = UR.findUserById(id);
        if (U == null) return "erreur , utilisateur inexistant";

        PortMonnais P = PR.findPortMonnaisByIdUser(id);
        if (P == null) return "utilisateur n a pas un port monnais";

        PR.delete(P);
        return "port monnais de l utilisaterr d ID =  " + id + "  a ete supprimer avec sucess";

    }

    public String bloquerPortUser(long idUser) {


User U=UR.findUserById(idUser);
if(U==null) return "utilisateur inexistant";

        PortMonnais P= PR.findPortMonnaisByIdUser(idUser);
        if(P==null) return "port monnais inexistant";

        P.setEtat("B");
        PR.save(P);
        return "portMonnais est bloquer";

    }

    public String activerPortUser(long idUser) {
        User U=UR.findUserById(idUser);
        if(U==null) return "utilisateur inexistant";

        PortMonnais P= PR.findPortMonnaisByIdUser(idUser);
        if(P==null) return "port monnais inexistant";

        P.setEtat("A");
        PR.save(P);
        return "portMonnais est activer";
    }

public String getSoldeByIdUser(long idUser){
        String etat="";
        PortMonnais P=PR.findPortMonnaisByIdUser(idUser);
        if(P!=null){
            etat=P.getEtat();
            if(etat.charAt(0)=='A') return "Votre Solde = "+P.getSolde()+" "+" PortMonnais est active";
            else return "Votre Solde = "+P.getSolde()+"/n"+" PortMonnais est Bloquer SVP de contacter l Admin";
        }

     else return "il faut cree un PortMonnais";
}

}




