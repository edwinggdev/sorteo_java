/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.Usuario;
import com.example.demo.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LENOVO
 */
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
    @Transactional(readOnly=true)
    @Query(value="select count (id) from venta where sorteo = ?1", nativeQuery = true)
    public int findBoletoNumero(Integer sorteo_id);
    
}
