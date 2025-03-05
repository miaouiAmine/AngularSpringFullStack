package com.grokonez.jwtauthentication.repository;


import com.grokonez.jwtauthentication.model.CouponVenduJour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupJourRepository extends JpaRepository<CouponVenduJour,Long> {



}
