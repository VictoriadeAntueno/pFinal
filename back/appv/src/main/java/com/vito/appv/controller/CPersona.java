/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vito.appv.controller;

import com.vito.appv.dto.dtoPersona;
import com.vito.appv.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CPersona {
    @Autowired
    dtoPersona dtopersona;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return dtopersona.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        dtopersona.savePersonas(persona);
        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        dtopersona.deletePersonas(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg,
            @RequestParam("prof") String nuevoProf) {
        Persona persona = dtopersona.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setId(id);
        persona.setProf(nuevoProf);

        dtopersona.savePersonas(persona);
        return persona;
    }

    @GetMapping("personas/traer/perfil")
    public Persona findPersona() {
        return dtopersona.findPersona((long) 1);
    }
    
}