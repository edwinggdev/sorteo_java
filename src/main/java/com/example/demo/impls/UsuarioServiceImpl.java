/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.impls;

import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.services.IUsuarioService;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional(readOnly = true)
    /*@Override
    public Usuario findById(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return usuarioRepository.findById(id).orElse(null);
    }*/

    @Override
    public Usuario save(Usuario usuario) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByCedula(String cedula) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (Usuario) usuarioRepository.findByCedula(cedula);
    }

    @Override
    public Usuario findById(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return usuarioRepository.findById(id).orElse(null);
    }
    
    
    
}
