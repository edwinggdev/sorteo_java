/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.impls;

import com.example.demo.models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.VentaRepository;
import com.example.demo.services.IVentaService;

/**
 *
 * @author LENOVO
 */
@Service
public class VentaServiceImpl implements IVentaService {
        @Autowired
    private VentaRepository ventaRepository;
        
    @Override
    public Venta save(Venta venta) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ventaRepository.save(venta);
    }

    @Override
    public int findBoletoNumero(int sorteo_id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ventaRepository.findBoletoNumero(sorteo_id);
    }
    
}
