package com.grokonez.jwtauthentication.Servicess;



import com.grokonez.jwtauthentication.model.*;
import com.grokonez.jwtauthentication.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Date;
import java.util.List;



@Service
public class AchatService {
    @Autowired
    private achatRepository AR;

    @Autowired
    private UserRepository UR;
    @Autowired
    private UserService US;


    @Autowired
    private PortMonnaisService PS;
    @Autowired
    private PortMonnaisRepository PR;

@Autowired
private CouponService CS;
@Autowired
private CouponRepository CR;

@Autowired
private TopTenUsersService TTS;

@Autowired
private TopTenUserRepository TTR;


public List<Achats> findAllAchats(){
    return AR.findAll();
}

    public List<Achats> achatClientByIdUser(long idUser){
         List<Achats> L =AR.findAchatsByIdUser(idUser);
        if(L==null)
            return null;
        else
            return L;
    }



    public List<Achats> achatClientByIdCoupon(long idCoupon){
        List<Achats> L =AR.findAchatsByIdCoupon(idCoupon);
        if(L==null)
            return null;
        else
            return L;
    }

    public String achCoupon(long idUser, long idCoupon){
    Date d = new Date();
    User U = UR.findUserById(idUser);
    if(U == null) return "utilisateur inexistant";
        PortMonnais P = PR.findPortMonnaisByIdUser(idUser);
        if (P == null) return "Tu n a pas un port monnais";

        Coupon C =CS.getCouponByID(idCoupon);
        if(C== null) return "Coupon inexistant";

        if(C.getQuantite() == 0) return "il n exist plus de coupon dans le stock";
        if(C.getPrixCoupon()>P.getSolde()) return "solde insuffisant";

        if(P.getEtat().charAt(0)=='B' ||P.getEtat().charAt(0)=='b') return "Portmonnais bloquer";

        User Uu = UR.findUserById(idUser);
        Coupon Cc =CS.getCouponByID(idCoupon);
        PortMonnais Pp = PR.findPortMonnaisByIdUser(idUser);
        Achats ach = new Achats();


        ach.setDateAchat(d);
        ach.setIdCoupon(idCoupon);
        ach.setIdUser(idUser);
        ach.setPrixCoupon(Cc.getPrixCoupon());
        ach.setNomUser(Uu.getName());


        Cc.setQuantite(Cc.getQuantite()-1);
CR.save(Cc);
long soldeA=Pp.getSolde();
long soldAp=Pp.getSolde()-Cc.getPrixCoupon();
ach.setSoldeAvant(soldeA);
Pp.setSolde(Pp.getSolde()-Cc.getPrixCoupon());
ach.setSoldeApres(soldAp);
PR.save(Pp);
AR.save(ach);

List<TopTenUses> l =TTR.findAll();
int cont = 0;

for(int i=0;i<=l.size()-1;i++){

    if(Uu.getId()==l.get(i).getIdUser())
    { l.get(i).setSomme(l.get(i).getSomme()+Cc.getPrixCoupon());
    TTR.saveAll(l);
    cont=cont+1;
    }
}
if(cont==0){
    TopTenUses T=new TopTenUses();
    T.setIdUser(Uu.getId());
    T.setSomme(Cc.getPrixCoupon());
    T.setName(Uu.getName());

    TTR.save(T);
}

    return  "coupon acheter acec sucess";

    }


}
