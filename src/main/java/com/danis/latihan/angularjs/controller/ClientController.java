/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.controller;

import com.danis.latihan.angularjs.dao.ClientDao;
import com.danis.latihan.angularjs.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TOSHIBA
 */
@RestController
@RequestMapping("/api")
public class ClientController {
    
    @Autowired
    private ClientDao cd;
    
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public Page<Client> getFindClient(Pageable page){
        return cd.findAll(page);
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public void clientSave(@RequestBody Client c){
        cd.save(c);
    }
}
