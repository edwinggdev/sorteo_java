/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.impls;

import com.example.demo.models.Numero;
import com.example.demo.repositories.NumeroRepository;
import com.example.demo.services.INumeroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NumeroServiceImpls implements INumeroService{
    @Autowired
    private NumeroRepository numeroRepository;
    /*@Override
    public List<Numero> findBySorteoId() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return numeroRepository.findAll();
    }*/

    @Override
    public List<Numero> findBySorteoId(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return numeroRepository.findBySorteoId(Integer.parseInt(id + ""));
    }

    @Override
    public Numero findByFreeNumero(Long id, Integer numero) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return numeroRepository.findByFreeNumero(Integer.parseInt(id + ""), numero);
    }

    @Override
    public void findByNumeroBloquear(Long id, Integer numero) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        numeroRepository.findByNumeroBloquear(Integer.parseInt(id + ""), numero);
    }
    
    
    
}
