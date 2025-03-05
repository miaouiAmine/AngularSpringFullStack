package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.GiftCode;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.model.Utilisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface utilisationRepository extends JpaRepository<Utilisation, Long> {



List<Utilisation> findUtilisationByCodeText(String coeText);
List<Utilisation> findUtilisationByIdUser(long idUser);
List<Utilisation> findAllByCodeTextAndIdUser(String codeText,long idUser);

List<Utilisation> findAllByCodeText(String codeText);
List<Utilisation> findAllByIdCode(long idCode);
}
