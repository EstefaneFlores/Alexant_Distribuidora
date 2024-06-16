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

import Models.entitys.Persona;
import Models.service.service.IPersonaService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PersonaController {
    
    @Autowired
    private IPersonaService iPersonaService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroPersona")
    public String registroCliente(@Validated Persona persona, Model model) {

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "formularios/formModeloPersona";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarPersona")
    public String RegistrarPersona(@Validated Persona persona) {
        persona.setEstado_per("A");
        iPersonaService.save(persona);
        return "redirect:/ListasPersona";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarPersona/{id_persona}")
    public String eliminarPersona(@PathVariable("id_persona") Integer id_persona) {

        Persona persona = iPersonaService.findOne(id_persona);
        persona.setEstado_per("X");
        iPersonaService.save(persona);
        return "redirect:/ListasPersona";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/Listaspersonas")
    public String listarpersona(Model model) {

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "listas/listaPersona";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/persona/{idPersona}")
    public String getContentPersona(@PathVariable(value = "idPersona") Integer idPersona, Model model,
            HttpServletRequest request) {

        model.addAttribute("persona", iPersonaService.findOne(idPersona));

        return "contentPersona :: contentpersona";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarPersona")
    public String getRegistroPersona(Model model) {

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentPersona :: contentpersona";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosPersona")
    public String guardarCambiosPersona(@ModelAttribute Persona persona) {
        persona.setEstado_per("A");
        iPersonaService.save(persona);
        return "redirect:/ListasPersona";
    }
    
}
