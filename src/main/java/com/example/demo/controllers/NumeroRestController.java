/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.Numero;
import com.example.demo.services.INumeroService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LENOVO
 */
@CrossOrigin(origins = "/*")
@RestController
@RequestMapping("/numero")
public class NumeroRestController {
    @Autowired
    private INumeroService numeroService;
    
    
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    //public ResponseEntity<?> findByCedula(@Param(value = "cedula") String cedula) throws Exception{
    //public ResponseEntity<?> findById(@RequestParam(name = "id")  int sorteoId) throws Exception{
    public List<Numero> findById(@RequestParam(name = "id")  int sorteoId) throws Exception{
        Map<String, Object> response = new HashMap<>();
        List<Numero> numeros = null;
        try {
            //model.addAttribute("titulo", "Buscar usuario");
            System.out.println("1" + sorteoId);
            numeros = numeroService.findBySorteoId(Long.parseLong(sorteoId + ""));
            //response.put("numeros", numeros);

        }catch(Exception e){
            //throw new Exception(e.getMessage());
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        return numeros;
    }
    
    @RequestMapping(value = "/disponible", method = RequestMethod.GET)
    //public ResponseEntity<?> findByCedula(@Param(value = "cedula") String cedula) throws Exception{
    public ResponseEntity<?> findByFreeNumero(@RequestParam(name = "id")  int sorteoId, @RequestParam(name="numero") int numero) throws Exception{

        Map<String, Object> response = new HashMap<>();
        Numero nro;
        try {
            //model.addAttribute("titulo", "Buscar usuario");
            System.out.println("1" + sorteoId);
            nro = numeroService.findByFreeNumero(Long.parseLong(sorteoId + ""), numero);
            //model.addAttribute("usuarios", usuario);
            response.put("numeroEntrada", numero);
            try{
                if(nro.isVendido())
                    response.put("encontrado","Numero ocupado");
                else
                    response.put("encontrado","Disponible");
            }catch(Exception e){ 
                response.put("encontrado","Numero no Asociado a este sorteo");
            }
            
        }catch(Exception e){
            //throw new Exception(e.getMessage());
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return usuario;
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
