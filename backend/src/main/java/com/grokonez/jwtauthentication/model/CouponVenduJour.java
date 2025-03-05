package com.grokonez.jwtauthentication.model;


import javax.persistence.*;

@Entity
@Table(name = "CouponJour")
public class CouponVenduJour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      long ID;
    long Daytime;
    long quantity;

    public CouponVenduJour() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getDaytime() {
        return Daytime;
    }

    public void setDaytime(long daytime) {
        Daytime = daytime;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
