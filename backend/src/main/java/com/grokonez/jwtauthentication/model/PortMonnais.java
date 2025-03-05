package com.grokonez.jwtauthentication.model;


import org.hibernate.engine.profile.Fetch;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="port_monnais")
public class PortMonnais {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idPortMonnais;

    long idUser;

    int solde;

    @Value("ACTIVE")
    String etat;

    public PortMonnais() {
    }


    public long getIdPortMonnais() {
        return idPortMonnais;
    }

    public void setIdPortMonnais(long idPortMonnais) {
        this.idPortMonnais = idPortMonnais;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}

