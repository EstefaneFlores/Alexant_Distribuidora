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

import Models.entitys.Biene;
import Models.service.service.IBieneService;
import jakarta.servlet.http.HttpServletRequest;



@Controller
public class BieneController {

    @Autowired
    private IBieneService iBieneService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroBiene")
    public String registroDip(@Validated Biene biene, Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", iBieneService.findAll());

        return "formularios/formModeloReceta";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarDip")
    public String RegistrarDip(@Validated Biene biene) {
        biene.setEstado_biene(1);
        iBieneService.save(biene);
        return "redirect:/ListasBiene";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarDip/{id_biene}")
    public String eliminarDip(@PathVariable("id_biene") Integer id_biene) {

        Biene biene = iBieneService.findOne(id_biene);
        biene.setEstado_biene(0);
        iBieneService.save(biene);
        return "redirect:/ListasDip";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasBiene")
    public String listarBiene(Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", iBieneService.findAll());

        return "listas/listaBiene";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/biene/{idBiene}")
    public String getContentDip(@PathVariable(value = "idBiene") Integer idBiene, Model model,
            HttpServletRequest request) {

        model.addAttribute("biene", iBieneService.findOne(idBiene));

        return "contentDip :: contentbiene";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarBiene")
    public String getRegistroDIP(Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", iBieneService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentDip :: contentdip";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDip")
    public String guardarCambiosDip(@ModelAttribute Biene biene) {
        biene.setEstado_biene(1);
        iBieneService.save(biene);
        return "redirect:/ListasBiene";
    }

    // -------------------------------------------------
}
