package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {


    void delete(Coupon coupon);



    Coupon findCouponByIdCoupon(long idCoupon);

boolean existsCouponByImageSource(Coupon c);



}
