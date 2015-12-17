/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.dao;

import com.danis.latihan.angularjs.AppJavaAndAngularJsApplication;
import com.danis.latihan.angularjs.entity.Client;
import com.danis.latihan.angularjs.entity.Product;
import com.danis.latihan.angularjs.entity.Purchasing;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author TOSHIBA
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppJavaAndAngularJsApplication.class)
public class CrudTest {
    
    @Autowired
    private ClientDao cd;
    
    @Autowired
    private ProductDao pd;
    
    @Autowired
    private PurchasingDao pu;
    
    @Autowired
    private DataSource ds;
    
    @Ignore
    @Test
    public void insertData() throws SQLException{
        Client cl = new Client("Danis", UUID.randomUUID().toString(), Date.from(Instant.now()));
        cd.save(cl);
        
        Product p = new Product(UUID.randomUUID().toString(),"Softex");
        pd.save(p);
        
        Client cl1 = new Client();
        cl1.setIdClient("6bc352c2-6330-433c-87a0-aa34df7bae31");
        
        Client cl2 = new Client();
        cl2.setIdClient("7cafe099-cab0-4879-8faf-f6e7f587a7b9");
        
        Product p1 = new Product();
        p1.setIdProduct("0e6dba53-81bd-48a0-a5d6-721ecca4a1f2");
        
        Purchasing purc = new Purchasing();
        purc.setProduct(p1);
        purc.setJumlah(1);
        purc.setHargaSatuan(2000.0);
        purc.setHargaTotal(2000.0);
        purc.getListClient().add(cl1);
        purc.getListClient().add(cl2);
        pu.save(purc);
        
        String sql = "select count(*) as jumlah from client where nama='Danis'";
        String sql1 = "select count(*) as jumlah from product where nama='Softex'";
        
        Connection c = ds.getConnection();
        try {
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            
            Long jumlah = rs.getLong("jumlah");
            Assert.assertEquals(6L, jumlah.longValue());
            
            
            ResultSet rs1 =c.createStatement().executeQuery(sql1);
            Assert.assertTrue(rs1.next());
            
            Long jml = rs1.getLong("jumlah");
            Assert.assertEquals(6L, jml.longValue());
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudTest.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            c.close();
        }
        
    }
    
}
