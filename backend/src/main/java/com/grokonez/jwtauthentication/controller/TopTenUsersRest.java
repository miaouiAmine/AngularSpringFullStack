package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.Servicess.TopTenUsersService;
import com.grokonez.jwtauthentication.model.Coupon;
import com.grokonez.jwtauthentication.model.TopTenUses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/TopTenUsers")
public class TopTenUsersRest {


    @Autowired
    private TopTenUsersService TTUS;



    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/getTopTen")
    public List<TopTenUses> getTopTen() {
        return this.TTUS.getTopTen();
    }

}
