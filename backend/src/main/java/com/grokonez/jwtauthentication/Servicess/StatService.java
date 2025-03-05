package com.grokonez.jwtauthentication.Servicess;
import com.grokonez.jwtauthentication.model.Achats;
import com.grokonez.jwtauthentication.repository.achatRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatService {

   @Autowired
   private AchatService AS;
   @Autowired
   private achatRepository AR;

   @Autowired
    private UserService US;

   @Autowired
    private CouponService CS;


   public List<Long> TopTenUsers(){

List<Achats> LA=AR.findAll();
if(LA==null)return null;

int LMS=LA.size()-1;
List<String> names=new ArrayList<String>();

for (int a=0;a<=LMS;a++) {
    Achats A = LA.get(a);
    String nom = A.getNomUser();
if(!names.contains(nom))
    names.add(nom);
}
int namesMaxSize=names.size()-1;
/* names contient la list des nomes des utilisateurs dans la table achats */

       List<Long>lesPointes = new ArrayList<Long>();

for (int b =0;b<=namesMaxSize;b++){lesPointes.add(b, (long) 0);}

        for(int s=0;s<=names.size()-1;s++) {
            List<Achats> listUser=AR.getAllByNomUser(names.get(s));
long somme = 0;
for(int f=0;f<=listUser.size()-1;f++){
    somme=somme+listUser.get(f).getPrixCoupon();

}lesPointes.set(s,somme);

            }
return lesPointes;

   }
}
