/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

/**
 *
 * @author LENOVO
 */
public class VentaTemp {
    private int sorteo_id;
    //private String cedula;
    private int cedula_id;
    private int numero1;
    private int numero2;
    private int numero3;
    private int numero4;
    private Double total;
    private int boleto;
    private String comprador;
    private String mensaje;

    public int getSorteo_id() {
        return sorteo_id;
    }

    public void setSorteo_id(int sorteo_id) {
        this.sorteo_id = sorteo_id;
    }

    
    public int getCedula_id() {
        return cedula_id;
    }

    /*public String getCedula() {
    return cedula;
    }
    public void setCedula(String cedula) {
    this.cedula = cedula;
    }*/
    public void setCedula_id(int cedula_id) {
        this.cedula_id = cedula_id;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getNumero3() {
        return numero3;
    }

    public void setNumero3(int numero3) {
        this.numero3 = numero3;
    }

    public int getNumero4() {
        return numero4;
    }

    public void setNumero4(int numero4) {
        this.numero4 = numero4;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getBoleto() {
        return boleto;
    }

    public void setBoleto(int boleto) {
        this.boleto = boleto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
    
    
}
