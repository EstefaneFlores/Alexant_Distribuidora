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
    public String registroBiene(@Validated Biene biene, Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", iBieneService.findAll());

        return "formularios/formModeloBiene";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarDip")
    public String RegistrarBiene(@Validated Biene biene) {
        biene.setEstado_biene("A");
        iBieneService.save(biene);
        return "redirect:/ListasBiene";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarBiene/{id_biene}")
    public String eliminarBiene(@PathVariable("id_biene") Integer id_biene) {

        Biene biene = iBieneService.findOne(id_biene);
        biene.setEstado_biene("X");
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
    public String getContentBiene(@PathVariable(value = "idBiene") Integer idBiene, Model model,
            HttpServletRequest request) {

        model.addAttribute("biene", iBieneService.findOne(idBiene));

        return "contentBiene :: contentbiene";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarBiene")
    public String getRegistroBiene(Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", iBieneService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentBiene :: contentbiene";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDip")
    public String guardarCambiosBiene(@ModelAttribute Biene biene) {
        biene.setEstado_biene("A");
        iBieneService.save(biene);
        return "redirect:/ListasBiene";
    }

    // -------------------------------------------------
}
