/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LENOVO
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    /**
     *
     * @param cedula
     * @return
     */
    @Transactional(readOnly=true)
    @Query(value="select * from usuario u where u.cedula = ?1 Limit 1", nativeQuery = true)
    public Usuario findByCedula(@Param("cedula") String cedula);
   // Usuario findByCedula(String cedula);
    
   /* @Transactional(readOnly=true)
    @Query(value="select * from usuario u where u.id = ?1 Limit 1", nativeQuery = true)
    public Usuario findById(@Param("id") String cedula);*/
}
