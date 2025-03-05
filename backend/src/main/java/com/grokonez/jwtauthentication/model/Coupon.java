package com.grokonez.jwtauthentication.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.transform.Source;
import java.net.URL;


@Entity
@Table(name = "coupons")
public class Coupon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCoupon;


    int prixCoupon;


    String descCoupon;


    String socCoupon;

    int quantite;


    @Size(max = 1000)
    String imageSource;


    public Coupon() {
    }

    public long getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(long idCoupon) {
        this.idCoupon = idCoupon;
    }

    public int getPrixCoupon() {
        return prixCoupon;
    }

    public void setPrixCoupon(int prixCoupon) {
        this.prixCoupon = prixCoupon;
    }

    public String getDescCoupon() {
        return descCoupon;
    }

    public void setDescCoupon(String descCoupon) {
        this.descCoupon = descCoupon;
    }

    public String getSocCoupon() {
        return socCoupon;
    }

    public void setSocCoupon(String socCoupon) {
        this.socCoupon = socCoupon;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }


}
