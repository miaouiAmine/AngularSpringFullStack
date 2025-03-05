package com.grokonez.jwtauthentication.Servicess;


import com.grokonez.jwtauthentication.model.Achats;
import com.grokonez.jwtauthentication.model.Coupon;
import com.grokonez.jwtauthentication.repository.CouponRepository;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository CR;


    public List<Coupon> findAllCoupons() {
        return CR.findAll();
    }

    public Coupon getCouponByID(long idCoupon) {

        return CR.findCouponByIdCoupon(idCoupon);
    }

    public String addCoupon(Coupon coupon) {

        int e = 0;

        int qu = coupon.getQuantite();
        int pr = coupon.getPrixCoupon();

        if (qu < 0) e = e + 1;

        if (pr <= 0) e = e + 10;


        if (e == 1) return JSONParser.quote("erreur,quantite negative");
        if (e == 10) return JSONParser.quote("erreur,prix null or negative");
        if (e == 11) return JSONParser.quote("erreu,change le prix et la quantite");


        CR.save(coupon);
        return JSONParser.quote("coupon ajouter avec sucess");


    }

    public void deleteById(long idCoupon) {
        boolean test = CR.existsById(idCoupon);
        if (test == true) {
            CR.deleteById(idCoupon);
        }
    }


    public String updateStock(long idCoupon,int newStock){
        String message="Coupon inexistant";
        boolean test = CR.existsById(idCoupon);

        if (test == true) {
            Coupon C = getCouponByID(idCoupon);
            C.setQuantite(newStock);
            CR.save(C);
            message="update avec Success";
            return JSONParser.quote(message);
        }else
        return JSONParser.quote(message);
    }


}
