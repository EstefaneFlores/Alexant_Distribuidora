package com.example.Alexant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Alexant.Models.entitys.Rol;
import com.example.Alexant.Models.service.service.IRolService;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RolController {
    
    @Autowired
    private IRolService iRolService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroRol")
    public String registroRol(@Validated Rol rol, Model model) {

        model.addAttribute("rol", new Rol());
        model.addAttribute("roles", iRolService.findAll());

        return "formularios/formModeloRol";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarRol")
    public String RegistrarRol(@Validated Rol rol) {
        rol.setEstado_rol("A");
        iRolService.save(rol);
        return "redirect:/ListasRol";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarRol/{id_rol}")
    public String eliminarRol(@PathVariable("id_rol") Integer id_rol) {

        Rol rol = iRolService.findOne(id_rol);
        rol.setEstado_rol("X");
        iRolService.save(rol);
        return "redirect:/ListasRol";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/Listasrol")
    public String listarRol(Model model) {

        model.addAttribute("rol", new Rol());
        model.addAttribute("roles", iRolService.findAll());

        return "listas/listaRol";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/rol/{idRol}")
    public String getContentRol(@PathVariable(value = "idRol") Integer idRol, Model model,
            HttpServletRequest request) {

        model.addAttribute("rol", iRolService.findOne(idRol));

        return "contentRol :: contentRol";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarRol")
    public String getRol(Model model) {

        model.addAttribute("rol", new Rol());
        model.addAttribute("roles", iRolService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentRol :: contentRol";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosRol")
    public String guardarCambiosRol(@ModelAttribute Rol rol) {
        rol.setEstado_rol("A");
        iRolService.save(rol);
        return "redirect:/ListasRol";
    }
}
