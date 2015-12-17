/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.entity;

import com.danis.latihan.angularjs.dao.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author TOSHIBA
 */
@Entity
public class Client extends AbstractEntity implements Serializable{
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id_client")
    private String idClient;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(name = "tanggal_lahir",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tglLahir;

    public Client() {
    }

    public Client(String nama, String email, Date tglLahir) {
        this.nama = nama;
        this.email = email;
        this.tglLahir = tglLahir;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nama=" + nama + ", email=" + email + ", tglLahir=" + tglLahir + '}';
    }    
}
