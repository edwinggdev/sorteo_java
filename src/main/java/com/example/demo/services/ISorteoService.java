/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import java.awt.print.Pageable;
import java.util.List;
import com.example.demo.models.Sorteo;
import org.springframework.data.domain.Page;

/**
 *
 * @author LENOVO
 */
public interface ISorteoService {
     public List<Sorteo> findAll();

    public Page<Sorteo> findAll(Pageable pageable);

    public Sorteo findById(Long id);
    
    public Sorteo findByIdImg(Long  id);

   // public void delete(Long id);
}
