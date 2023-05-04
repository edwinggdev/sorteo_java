/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.Venta;

/**
 *
 * @author LENOVO
 */
public interface IVentaService {
    public Venta save(Venta cliente);
    public int findBoletoNumero(int sorteo_id);
}
