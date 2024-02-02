package com.ieseljust.ad.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RecordCompany")
public class RecordCompany implements Serializable{
    
    static final long serialVersionUID = 137L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idRC;
    
    @Column
    private String name;
    
    @Column
    private String country;

    public RecordCompany() {
    }

    public RecordCompany(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public int getIdRC() {
        return idRC;
    }

    public void setIdRC(int idRC) {
        this.idRC = idRC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
       
}
