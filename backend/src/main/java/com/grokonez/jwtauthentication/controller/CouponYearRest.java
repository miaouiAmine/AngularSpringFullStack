package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.Servicess.CouponYearService;
import com.grokonez.jwtauthentication.model.CouponVenduYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/couponYear")
public class CouponYearRest {

    @Autowired
    private CouponYearService CYS;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(path = "/getCoupYear")
    public List<CouponVenduYear> CoupYearFunction() {
        return CYS.getInYear();
    }



}
