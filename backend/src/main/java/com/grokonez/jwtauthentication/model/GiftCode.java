package com.grokonez.jwtauthentication.model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "gift_codes")
public class GiftCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCode;



    String codeText;


    int codeValue;


    Date dateDebut;


    Date dateFin;


    int nbrUtilisation;

    int nbrUtilisationMax;



    int reductionParUtilisation;



    public GiftCode() { }




    public long getIdCode() {
        return idCode;
    }

    public void setIdCode(long idCode) {
        this.idCode = idCode;
    }

    public String getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }

    public int getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(int codeValue) {
        this.codeValue = codeValue;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrUtilisationMax() {
        return nbrUtilisationMax;
    }

    public void setNbrUtilisationMax(int nbrUtilisationMax) {
        this.nbrUtilisationMax = nbrUtilisationMax;
    }

    public int getNbrUtilisation() {
        return nbrUtilisation;
    }

    public void setNbrUtilisation(int nbrUtilisation) {
        this.nbrUtilisation = nbrUtilisation;
    }

    public int getReductionParUtilisation() {
        return reductionParUtilisation;
    }

    public void setReductionParUtilisation(int reductionParUtilisation) {
        this.reductionParUtilisation = reductionParUtilisation;
    }
}
