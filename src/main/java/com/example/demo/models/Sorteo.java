/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="sorteo")
public class Sorteo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "no puede estar vacio")
    //@Column(nullable = false, length=30).
    private String nombre;
    
    @NotEmpty(message = "no puede estar vacio")
    private String descrip;
    
    @NotEmpty(message = "no puede estar vacio")
    private String fecha;
    
    @NotEmpty(message = "no puede estar vacio")
    private double valorb;
    
    private byte[] imgp1;
    private String imgp2;
    private String imgp3;
    
    @Column(length = 4)
    private Integer bdesde;
    @Column(length = 4)
    private Integer bhasta;
    
    //@JsonIgnoreProperties(value = {"sorteo", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "sorteo") //, cascade = CascadeType.ALL
    //private List<Venta> ventas;
    
    /*public Sorteo() {
        this.ventas = ventas;
    }*/
    
    /*public Sorteo(List<Venta> ventas) {
        this.ventas = ventas;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return descrip;
    }

    public void setDesc(String desc) {
        this.descrip = desc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValorb() {
        return valorb;
    }

    public void setValorb(double valorb) {
        this.valorb = valorb;
    }

   /* public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }*/

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public byte[] getImgp1() {
        return imgp1;
    }

    public void setImgp1(byte[] imgp1) {
        this.imgp1 = imgp1;
    }

    public String getImgp2() {
        return imgp2;
    }

    public void setImgp2(String imgp2) {
        this.imgp2 = imgp2;
    }

    public String getImgp3() {
        return imgp3;
    }

    public void setImgp3(String imgp3) {
        this.imgp3 = imgp3;
    }

    
 

    public int getBdesde() {
        return bdesde;
    }

    public void setBdesde(int bdesde) {
        this.bdesde = bdesde;
    }

    public int getBhasta() {
        return bhasta;
    }

    public void setBhasta(int bhasta) {
        this.bhasta = bhasta;
    }
    
    
    
}
