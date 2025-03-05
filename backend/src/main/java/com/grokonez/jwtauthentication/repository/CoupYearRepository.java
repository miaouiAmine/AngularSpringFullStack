package com.grokonez.jwtauthentication.repository;


import com.grokonez.jwtauthentication.model.CouponVenduYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupYearRepository extends JpaRepository<CouponVenduYear, Long> {


}
