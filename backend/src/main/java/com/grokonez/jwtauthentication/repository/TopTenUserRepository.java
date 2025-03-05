package com.grokonez.jwtauthentication.repository;


import com.grokonez.jwtauthentication.model.TopTenUses;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopTenUserRepository extends JpaRepository<TopTenUses,Long> {




}
