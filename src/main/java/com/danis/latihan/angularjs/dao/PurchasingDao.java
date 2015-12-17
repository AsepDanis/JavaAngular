/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.dao;

import com.danis.latihan.angularjs.entity.Purchasing;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author TOSHIBA
 */
public interface PurchasingDao extends PagingAndSortingRepository<Purchasing, String>{
    
}
