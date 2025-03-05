package com.grokonez.jwtauthentication.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name="utilisations")
public class Utilisation {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     long idUtilisation;


    Date dateUtilisation;

   long idUser;
long idCode;
   String codeText;

   int valeurAjouter;

    int soldeAvant;

    int soldeApres;


    public Utilisation() {
    }

    public long getIdUtilisation() {
        return idUtilisation;
    }

    public void setIdUtilisation(long idUtilisation) {
        this.idUtilisation = idUtilisation;
    }

    public Date getDateUtilisation() {
        return dateUtilisation;
    }

    public void setDateUtilisation(Date dateUtilisation) {
        this.dateUtilisation = dateUtilisation;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }

    public int getValeurAjouter() {
        return valeurAjouter;
    }

    public void setValeurAjouter(int valeurAjouter) {
        this.valeurAjouter = valeurAjouter;
    }

    public int getSoldeAvant() {
        return soldeAvant;
    }

    public void setSoldeAvant(int soldeAvant) {
        this.soldeAvant = soldeAvant;
    }

    public int getSoldeApres() {
        return soldeApres;
    }

    public void setSoldeApres(int soldeApres) {
        this.soldeApres = soldeApres;
    }

    public long getIdCode() {
        return idCode;
    }

    public void setIdCode(long idCode) {
        this.idCode = idCode;
    }
}
