package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.Servicess.CouponJourService;
import com.grokonez.jwtauthentication.Servicess.CouponYearService;
import com.grokonez.jwtauthentication.model.CouponVenduJour;
import com.grokonez.jwtauthentication.model.CouponVenduYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/couponJour")
public class CouponJourRest {


    @Autowired
    private CouponJourService CJS;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(path = "/getCoupJour")
    public List<CouponVenduJour> CoupDayFunction() {
        return CJS.getInDay();
    }



}
