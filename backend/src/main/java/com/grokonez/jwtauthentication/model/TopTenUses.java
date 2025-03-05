package com.grokonez.jwtauthentication.model;


import javax.persistence.*;

@Entity
@Table(name="TopTenUsers")
public class TopTenUses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long idUser;
    String Name;
    long Somme;

    public TopTenUses() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getSomme() {
        return Somme;
    }

    public void setSomme(long somme) {
        Somme = somme;
    }
}
