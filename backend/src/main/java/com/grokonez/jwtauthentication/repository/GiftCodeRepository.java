package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.GiftCode;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface GiftCodeRepository extends JpaRepository<GiftCode,Long> {



    Optional<GiftCode> findById(long id);
    GiftCode findGiftCodeByCodeText(String s);

    GiftCode findGiftCodeByIdCode(long idCode);



    List<GiftCode> findAllByOrderByIdCodeAsc();
}
