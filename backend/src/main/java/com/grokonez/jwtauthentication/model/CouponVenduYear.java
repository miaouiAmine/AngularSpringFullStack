package com.grokonez.jwtauthentication.model;


import javax.persistence.*;

@Entity
@Table(name = "CouponYear")
public class CouponVenduYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long ID;
    String month;
    long quantity;

    public CouponVenduYear() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
