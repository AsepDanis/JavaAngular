/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.controller;

import com.danis.latihan.angularjs.dao.ClientDao;
import com.danis.latihan.angularjs.entity.Client;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
        Page result = cd.findAll(page);
        System.out.println("Total Jumlah Data: "+result.getTotalElements());
        return result;
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ResponseEntity<Client> clientSave(@RequestBody Client c){
        Client result = cd.save(c);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.PUT)
    public  ResponseEntity<Client> clientUpdate(@RequestBody Client c){
        Client result = cd.save(c);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
   
    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> clientFindbyId(@PathVariable String id){
        Client result = cd.findOne(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Void> clientDelete(@PathVariable String id){
        cd.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
