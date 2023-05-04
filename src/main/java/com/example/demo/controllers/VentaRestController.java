/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.Detalle;
import com.example.demo.models.Usuario;
import com.example.demo.models.Venta;
import com.example.demo.models.VentaTemp;
import com.example.demo.services.IDetalleService;
import com.example.demo.services.INumeroService;
import com.example.demo.services.IUsuarioService;
import com.example.demo.services.IVentaService;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/venta")
public class VentaRestController {
    @Autowired
    private IVentaService ventaService;
    
    @Autowired
    private IDetalleService detalleService;
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
    private INumeroService numeroService;
    
    @RequestMapping("/hola")
     public String home(){
         return " Hola Venta!";
     }
    
     
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(readOnly = false)
    //public ResponseEntity<?> create(@RequestBody VentaTemp  v) {
    public VentaTemp create(@RequestBody VentaTemp  v) {
        Venta ventaNew = new Venta();
        Venta venta = new Venta();
        Map<String, Object> response = new HashMap<>();
        int sorteo_id = v.getSorteo_id();
        int boleto;
        Usuario comprador = new Usuario();
        try {
            
            //return ResponseEntity.status(HttpStatus.CREATED)
            //        .body(marcaService.save(marca));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            //System.out.println("yyyy/MM/dd HH:mm:ss-> "+);
            Date fecha = new Date();
           
            //obtener el maximo numero de boleto e incrementar
            boleto = (ventaService.findBoletoNumero(sorteo_id));
            venta.setBoleto(boleto + 1);
            v.setBoleto(boleto);
            System.out.println("boleto Generado:" + boleto);
            
            response.put("venta", v);
            venta.setFecha(fecha); System.out.println("fecha: " + fecha);
            System.out.println("sorteoid:" + sorteo_id );
            venta.setSorteo(v.getSorteo_id());
            System.out.println("ced id:" + v.getCedula_id());
            venta.setUsuario(v.getCedula_id());
            ventaNew = ventaService.save(venta);
            Long ventaid = ventaNew.getId();
            
            Detalle d = new Detalle();
            
            Detalle d1 = new Detalle();
            d1.setSorteoid(Long.parseLong(v.getSorteo_id()+ ""));
            d1.setNumero(v.getNumero1());
            d1.setVentaid(ventaid);
            d = detalleService.save(d1);
            numeroService.findByNumeroBloquear(Long.parseLong(v.getSorteo_id()+""), v.getNumero1());
            
            if(v.getNumero2() != 0){
                Detalle d2 = new Detalle();
                d2.setSorteoid(Long.parseLong(v.getSorteo_id()+ ""));
                d2.setNumero(v.getNumero2());
                d2.setVentaid(ventaid);
                d = detalleService.save(d2);
                numeroService.findByNumeroBloquear(Long.parseLong(v.getSorteo_id()+""), v.getNumero2());
            }
            
            if(v.getNumero2() != 0){
                Detalle d3 = new Detalle();
                d3.setSorteoid(Long.parseLong(v.getSorteo_id()+ ""));
                d3.setNumero(v.getNumero3());
                d3.setVentaid(ventaid);
                d = detalleService.save(d3);
                numeroService.findByNumeroBloquear(Long.parseLong(v.getSorteo_id()+""), v.getNumero3());
            }
            if(v.getNumero2() != 0){
                    Detalle d4 = new Detalle();
                    d4.setSorteoid(Long.parseLong(v.getSorteo_id()+ ""));
                    d4.setNumero(v.getNumero4());
                    d4.setVentaid(ventaid);
                    d = detalleService.save(d4);
                    numeroService.findByNumeroBloquear(Long.parseLong(v.getSorteo_id()+""), v.getNumero4());
            }
            
            v.setMensaje( "La Venta ha sido creada con éxito!");
            
            //obtener el nombre del usuario
            comprador = usuarioService.findById(Long.parseLong(v.getCedula_id()+ ""));
            System.out.println("" + comprador.getNombres());
            v.setComprador(comprador.getNombres());
        
        } catch (DataAccessException e) {
            //return ResponseEntity.notFound().build();
            //response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            v.setMensaje( "Error: " + e.getMessage().concat(": ").concat(e.getMessage()));
            //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            return v;
        }
        //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        return v;
    }
}
