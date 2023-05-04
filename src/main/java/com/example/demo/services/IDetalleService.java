/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.Detalle;

/**
 *
 * @author LENOVO
 */
public interface IDetalleService {
    public Detalle findById(Long id);
    public Detalle findByNumero(Integer numero);
    public Detalle save(Detalle detalle);
}
