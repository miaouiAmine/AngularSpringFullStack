package com.grokonez.jwtauthentication.Servicess;



import com.grokonez.jwtauthentication.model.PortMonnais;
import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.PortMonnaisRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository UR;
    @Autowired
    PortMonnaisRepository PR;

public User getUserByName(String name){

    User U=UR.findUserByName(name);
    if(U==null)return null;
    else return U;


}
    public User getUserById(long id){

        User U=UR.findUserById(id);
        if(U==null)return null;
        else return U;


    }
public long UserIdFromName(String name){

    User U =UR.findUserByName(name);
    if(U != null) return U.getId();
    else
    return -1;
}
public String AchterCoupon(long idUser,long idCoupon){

    return "f";
}


public List<User> allUser(){
    return UR.findAll();
}



public long getIdFromName(String name){

    User U=UR.findUserByName(name);
    if(U!=null)
    return U.getId();
    else return -1;
}




}



