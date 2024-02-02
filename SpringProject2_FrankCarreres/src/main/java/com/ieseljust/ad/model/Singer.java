package com.ieseljust.ad.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Singers")
public class Singer implements Serializable {
	private static final long serialVersionUID = 137L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSingers;

    @Column
    private String name;

    @OneToMany(mappedBy = "theSinger", cascade = CascadeType.PERSIST)
    private Set<Albums> theAlbums;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recordCompanyID", referencedColumnName = "idRC", unique = true)
    private RecordCompany rc;

    public Singer() {
    }

    public Singer(String name, RecordCompany recordCompany) {
        this.name = name;
        this.rc = recordCompany;
    }

    public int getIdSingers() {
        return idSingers;
    }

    public void setIdSingers(int idSingers) {
        this.idSingers = idSingers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Albums> getTheAlbums() {
        return theAlbums;
    }

    public void setTheAlbums(Set<Albums> theAlbums) {
        this.theAlbums = theAlbums;
    }

    public RecordCompany getRc() {
        return rc;
    }

    public void setRc(RecordCompany rc) {
        this.rc = rc;
    }
}
