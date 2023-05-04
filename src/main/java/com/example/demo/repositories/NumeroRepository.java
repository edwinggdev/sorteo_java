/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.Numero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author LENOVO
 */
public interface NumeroRepository extends JpaRepository<Numero, Long> {
    
    @Transactional(readOnly=true)
    @Query(value="select * from numero u where u.sorteo = ?1 AND u.vendido = false", nativeQuery = true)
    public List<Numero> findBySorteoId(Integer sorteoid);
    
    @Transactional(readOnly=true)
    @Query(value="select * from numero u where u.sorteo = ?1 AND u.numero = ?2 AND u.vendido = false", nativeQuery = true)
    public Numero findByFreeNumero(Integer sorteoid,Integer numero);
    
   // @Transactional(readOnly=false)
    @Modifying
    @Query(value="update numero set vendido = true where sorteo = ?1 AND numero = ?2", nativeQuery = true)
    public void findByNumeroBloquear(Integer sorteoid,Integer numero);
}
