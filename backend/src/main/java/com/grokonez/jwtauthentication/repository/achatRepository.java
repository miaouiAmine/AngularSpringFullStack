package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Achats;
import com.grokonez.jwtauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface achatRepository extends JpaRepository<Achats,Long> {

List<Achats> findAchatsByIdUser(long idUser);

List<Achats> findAchatsByIdCoupon(long idCoupon);

List<Achats> getAllByNomUser(String nom);



}
