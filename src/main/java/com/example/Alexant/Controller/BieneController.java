package com.example.Alexant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Alexant.Models.entitys.Biene;
import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.service.service.IBieneService;
import com.example.Alexant.Models.service.service.IPersonaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BieneController {
    
    @Autowired
    private IBieneService iBieneService;

     @Autowired
    private IPersonaService iPersonaService;

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarBiene")
    public String RegistrarBiene(@Validated Biene biene, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("biene", biene);
        model.addAttribute("bienes", iBieneService.findAll());

        model.addAttribute("personas", iPersonaService.findAll());
        
        return "redirect:/formAdministrarBiene";
    }
    biene.setEstado_biene("A");
    iBieneService.save(biene);
        return "redirect:/formAdministrarBiene";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarBiene/{id_biene}")
    public String eliminarBiene(@PathVariable("id_biene") Integer id_biene) {

        Biene biene = iBieneService.findOne(id_biene);
        biene.setEstado_biene("X");
        iBieneService.save(biene);
        return "redirect:/formAdministrarBiene";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/formAdministrarBiene")
    public String listarBiene(Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", iBieneService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "formBiene";
    }

    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/registrarBiene/{idBiene}")
    public String getContentBiene(@PathVariable(value = "idBiene") Integer idBiene, Model model,
            HttpServletRequest request) {

        model.addAttribute("biene", iBieneService.findOne(idBiene));

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "conten :: contentBiene";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarBiene")
    public String getRegistroBiene(Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", iBieneService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "conten :: contentBiene";
    }

    // --------------------------------------------
 
    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosBiene")
    public String guardarCambiosBiene(@ModelAttribute Biene biene, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("biene", biene);
            model.addAttribute("bienes", iBieneService.findAll());

            model.addAttribute("persona", new Persona());
            model.addAttribute("personas", iPersonaService.findAll());    
    
            return "redirect:/formAdministrarBiene";
        }
           
        biene.setEstado_biene("A");
        iBieneService.save(biene);
        return "redirect:/formAdministrarBiene";
    }
}
