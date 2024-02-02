package com.ieseljust.ad.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Albums")
public class Albums implements Serializable {

    private static final long serialVersionUID = 137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlbums;

    @Column
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "singerID")
    private Singer theSinger;

    public Albums() {
    }

    public Albums(String title, Singer theSinger) {
        this.title = title;
        this.theSinger = theSinger;
    }

    public int getIdAlbums() {
        return idAlbums;
    }

    public void setIdAlbums(int idAlbums) {
        this.idAlbums = idAlbums;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Singer getTheSinger() {
        return theSinger;
    }

    public void setTheSinger(Singer theSinger) {
        this.theSinger = theSinger;
    }
}