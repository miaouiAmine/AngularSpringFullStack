package com.grokonez.jwtauthentication.Servicess;


import com.grokonez.jwtauthentication.model.Achats;
import com.grokonez.jwtauthentication.model.CouponVenduJour;
import com.grokonez.jwtauthentication.repository.CoupJourRepository;
import com.grokonez.jwtauthentication.repository.achatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CouponJourService {


    @Autowired
     private CoupJourRepository CJR;
    @Autowired
    private achatRepository achR;




    public List<CouponVenduJour> getInDay(){
        List<CouponVenduJour> l = CJR.findAll();
        List<Achats> lch = achR.findAll();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");

        Date currDate=new Date();
        String date = format.format(currDate);

        int Year = Integer.parseInt(date.substring(0,4 ));
        int Month = Integer.parseInt(date.substring(5,7 ));
        int Day = Integer.parseInt(date.substring(8,10 ));
        int Hour = Integer.parseInt(date.substring(11,13 ));


        for(int a = 0 ; a<= lch.size()-1;a++) {

            Date dAch = lch.get(a).getDateAchat();
            String dAchS = format.format(dAch);

            int dYear = Integer.parseInt(dAchS.substring(0, 4));
            int dMonth = Integer.parseInt(dAchS.substring(5, 7));
            int dDay = Integer.parseInt(dAchS.substring(8, 10));
            int dHour = Integer.parseInt(dAchS.substring(11, 13));


            if(dYear == Year && dMonth == Month && dDay == Day){

                l.get(dHour).setQuantity(l.get(dHour).getQuantity()+1);
            }


        }


        return l;
    }


}
