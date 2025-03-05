package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.PortMonnais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PortMonnaisRepository extends JpaRepository< PortMonnais,Long> {

   PortMonnais findPortMonnaisByIdPortMonnais(long idPort);

     String deletePortMonnaisByIdUser(long idUser);
     PortMonnais findPortMonnaisByIdUser(long idUser);
}
