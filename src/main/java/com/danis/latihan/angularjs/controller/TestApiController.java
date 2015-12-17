/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danis.latihan.angularjs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TOSHIBA
 */
@RestController
public class TestApiController {
    
    @RequestMapping("/test")
    public Map<String, Object> getApi(@RequestParam(value = "nama", required = false) String nama){
        Map<String, Object> value = new HashMap<>();
        value.put("nama", nama);
        value.put("Waktu", new Date());
        return value;
    }
}