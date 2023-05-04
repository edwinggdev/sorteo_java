/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LENOVO
 */
public interface DetalleRepository extends JpaRepository<Detalle, Long> {

    public Detalle findByNumero(Integer numero);
    
}
