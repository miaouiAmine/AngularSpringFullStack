package com.grokonez.jwtauthentication.Servicess;


import com.grokonez.jwtauthentication.model.Achats;
import com.grokonez.jwtauthentication.model.CouponVenduYear;
import com.grokonez.jwtauthentication.repository.CoupYearRepository;
import com.grokonez.jwtauthentication.repository.achatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Date;
import java.util.List;

@Service
public class CouponYearService {

    @Autowired
    private CoupYearRepository CYR;
    @Autowired
    private achatRepository achR;
    @Autowired
    private AchatService achS;


    public List<CouponVenduYear> getInYear(){
        List<CouponVenduYear> l=CYR.findAll();
        List<Achats> lac=achR.findAll();
        Date currDate=new Date();
        String currDateString = currDate.toString();
        String currYear=currDateString.substring(currDateString.length()-4);
        int currY = Integer.parseInt(currYear);


for ( int a=0;a<=lac.size()-1;a++) {

    String s = lac.get(a).getDateAchat().toString();
    String sYear = s.substring(0, 4);
    int sY = Integer.parseInt(sYear);
    String sMonth = s.substring(5, 7);
    int Month = Integer.parseInt(sMonth);
    if(sY == currY){
        l.get(Month-1).setQuantity(l.get(Month-1).getQuantity()+1);
    }

}

        return l;
    }





}
