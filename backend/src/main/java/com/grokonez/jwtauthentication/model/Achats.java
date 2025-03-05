package com.grokonez.jwtauthentication.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name="achats")
public class Achats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAchat;
    Date dateAchat;
    long idUser;
    String nomUser;
    long idCoupon;
    long PrixCoupon;
    long SoldeAvant;
    long SoldeApres;

    public Achats() {
    }

    public long getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(long idAchat) {
        this.idAchat = idAchat;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(long idCoupon) {
        this.idCoupon = idCoupon;
    }

    public long getPrixCoupon() {
        return PrixCoupon;
    }

    public void setPrixCoupon(long prixCoupon) {
        PrixCoupon = prixCoupon;
    }

    public long getSoldeAvant() {
        return SoldeAvant;
    }

    public void setSoldeAvant(long soldeAvant) {
        SoldeAvant = soldeAvant;
    }

    public long getSoldeApres() {
        return SoldeApres;
    }

    public void setSoldeApres(long soldeApres) {
        SoldeApres = soldeApres;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }
}
