/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.impls;

import com.example.demo.models.Detalle;
import com.example.demo.repositories.DetalleRepository;
import com.example.demo.services.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LENOVO
 */
@Service
public class DetalleServiceImpl implements IDetalleService{
     @Autowired
    private DetalleRepository detalleRepository;
     
        @Transactional(readOnly = true)
    public Detalle findById(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return detalleRepository.findById(id).orElse(null);
    }

    @Override
    public Detalle findByNumero(Integer numero) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return detalleRepository.findByNumero(numero);
    }

    @Override
    public Detalle save(Detalle detalle) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return detalleRepository.save(detalle);
    }
}
