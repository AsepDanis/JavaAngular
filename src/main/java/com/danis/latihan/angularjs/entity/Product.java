/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.entity;

import com.danis.latihan.angularjs.dao.AbstractEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author TOSHIBA
 */

@Entity
public class Product extends AbstractEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="id_product")
    private String idProduct;
    
    @Column(nullable = false, unique = true)
    private String kode;
    
    @Column(nullable = false, length = 30)
    private String nama;
    
    @OneToMany(cascade = CascadeType.ALL, 
            orphanRemoval = true,
            mappedBy = "product")
    private List<Purchasing> listPurch = new ArrayList<>();

    public Product() {
    }

    public Product(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }
    
    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Purchasing> getListPurch() {
        return listPurch;
    }

    public void setListPurch(List<Purchasing> listPurch) {
        this.listPurch = listPurch;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", kode=" + kode + ", nama=" + nama + '}';
    }
}
