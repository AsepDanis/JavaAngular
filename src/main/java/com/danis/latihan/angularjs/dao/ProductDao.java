/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.dao;

import com.danis.latihan.angularjs.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author TOSHIBA
 */
public interface ProductDao extends PagingAndSortingRepository<Product, String>{
    
}
