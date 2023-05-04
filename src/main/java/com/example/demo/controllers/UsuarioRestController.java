/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import java.util.List;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.services.IUsuarioService;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LENOVO
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    @Autowired
    private IUsuarioService usuarioService;
    
    /*@GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> list() {
        return usuarioService.findAll();
    } */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> list() {
        
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "listado!");
        return usuarioService.findAll();
    }
    
    /*@GetMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> findAll(String cedula) {
        return usuarioService.findByCedula(cedula);
    }*/
    
    @RequestMapping(value = "/cedula", method = RequestMethod.GET)
    //public ResponseEntity<?> findByCedula(@Param(value = "cedula") String cedula) throws Exception{
        public Usuario findByCedula(@RequestParam(name = "cedula")  String cedula) throws Exception{

   // public ResponseEntity<?> findByCedula(@RequestParam(name = "cedula")  String cedula) throws Exception{

        Map<String, Object> response = new HashMap<>();
        Usuario usuario = null;
        try {
            //model.addAttribute("titulo", "Buscar usuario");
            System.out.println("1" + cedula);
            usuario = usuarioService.findByCedula(cedula);
            
            //model.addAttribute("usuarios", usuario);
            //response.values(usuario);// .put("", usuario);
            response.put("id", usuario.getId() + "");
            response.put("cedula",usuario.getCedula() );
            response.put("nombres",usuario.getNombres());
            response.put("telefono", usuario.getTelefono());

        }catch(Exception e){
            //throw new Exception(e.getMessage());
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return usuario;
        //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        //return new ResponseEntity<Usuario>((Usuario) response, HttpStatus.CREATED);
    }
    
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(readOnly = false)
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        Usuario usuarioNew = null;
        Map<String, Object> response = new HashMap<>();
        try {
            //return ResponseEntity.status(HttpStatus.CREATED)
            //        .body(marcaService.save(marca));
            response.put("usuario", usuario);
            usuarioNew = usuarioService.save(usuario);
            response.put("mensaje", "El Usuario ha sido creada con éxito!");
        
        } catch (DataAccessException e) {
            //return ResponseEntity.notFound().build();
            response.put("Error: ", e.getMessage().concat(": ").concat(e.getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    /*public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
        Usuario clienteNew = null;
        Map<String, Object> response = new HashMap<>();
        //System.out.println(usuario.getApellido());
        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            clienteNew = usuarioService.save(usuario);
            response.put("mensaje", "El cliente ha sido creado con éxito!");
        response.put("usuario", clienteNew);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }*/
}
