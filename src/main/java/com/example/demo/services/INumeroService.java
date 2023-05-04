/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.Numero;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public interface INumeroService {
    public List<Numero> findBySorteoId(Long id);
    public Numero findByFreeNumero(Long id, Integer numero);
    public void findByNumeroBloquear(Long id, Integer numero);
}
