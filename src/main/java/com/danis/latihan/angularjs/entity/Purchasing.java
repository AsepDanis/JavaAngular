/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author TOSHIBA
 */
@Entity
public class Purchasing implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idPurchasing;
    
    private Integer jumlah;
    private Double hargaSatuan;
    private Double hargaTotal;
    
    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;
    
    @ManyToMany
    @JoinTable(
            name = "list_client",
            joinColumns = @JoinColumn(name = "id_purchasing"), 
            inverseJoinColumns = @JoinColumn(name = "id_client"))
    private List<Client> listClient = new ArrayList<>(); 

    public Purchasing() {
    }

    public Purchasing(Integer jumlah, Double hargaSatuan, Double hargaTotal, Product product) {
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.hargaTotal = hargaTotal;
        this.product = product;
    }
    
    public String getIdPurchasing() {
        return idPurchasing;
    }

    public void setIdPurchasing(String idPurchasing) {
        this.idPurchasing = idPurchasing;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(Double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public Double getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(Double hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    @Override
    public String toString() {
        return "Purchasing{" + "idPurchasing=" + idPurchasing + ", jumlah=" + jumlah + ", hargaSatuan=" + hargaSatuan + ", hargaTotal=" + hargaTotal + '}';
    }
    
    
}
