/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.impls;

import java.awt.print.Pageable;
import java.util.List;
import com.example.demo.models.Sorteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repositories.SorteoRepository;
import com.example.demo.services.ISorteoService;

/**
 *
 * @author LENOVO
 */
@Service
public class SorteoServiceImpl implements ISorteoService {
    @Autowired
    private SorteoRepository sorteoRepository;

     @Override
    @Transactional(readOnly = true)
    public List<Sorteo> findAll() {
        return (List<Sorteo>) sorteoRepository.findAll();
    }
    
    @Override
    public Page<Sorteo> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true)
    public Sorteo findById(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return sorteoRepository.findById(id).orElse(null);
    }

    @Override
    public Sorteo findByIdImg(Long id) {
         return sorteoRepository.findById(id).orElse(null);
    }
    
}
