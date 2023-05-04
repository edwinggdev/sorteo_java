/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle")
public class Detalle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long sorteoid;
        
    private Long ventaid; 
    
    private Integer numero;

    public Detalle() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSorteoid() {
        return sorteoid;
    }

    public void setSorteoid(Long sorteoid) {
        this.sorteoid = sorteoid;
    }

    public Long getVentaid() {
        return ventaid;
    }

    public void setVentaid(Long ventaid) {
        this.ventaid = ventaid;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
