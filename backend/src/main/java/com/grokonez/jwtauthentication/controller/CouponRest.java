package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.Servicess.CouponService;
import com.grokonez.jwtauthentication.model.Coupon;
import com.grokonez.jwtauthentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

//tester
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/coupon")
public class CouponRest {

@Autowired
    private CouponService CS;
    //tester
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/getAllCoupons")
    public List<Coupon> getAllCoupon() {
        return CS.findAllCoupons();
    }


    //tester
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/getCouponById/{idCoupon}")
    public Coupon getCouponById(@PathVariable  long idCoupon) {
       return CS.getCouponByID(idCoupon);
    }
//tester
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addCoupon")
    public String addCoupon(@RequestBody Coupon coupon) {
        return CS.addCoupon(coupon);
    }
//tester
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteCouponById/{idCoupon}")
    public void deleteCouponById(@PathVariable long idCoupon) {
        CS.deleteById(idCoupon);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/updateStock/{idCoupon}/{newStock}")
    public String updateSolde(@PathVariable long idCoupon,@PathVariable int newStock) {
       return CS.updateStock(idCoupon,newStock);
    }

}
