/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import java.awt.print.Pageable;
import java.util.List;
import com.example.demo.models.Usuario;
import org.springframework.data.domain.Page;

/**
 *
 * @author LENOVO
 */
public interface IUsuarioService {

   // public Usuario findById(Long id);
    public List<Usuario> findAll();
    public Usuario findByCedula(String cedula);
    public Usuario findById(Long id);
    public Usuario save(Usuario usuario);
}
