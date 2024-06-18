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

import Models.entitys.Ruta;
import Models.service.service.IRutaService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RutaController {
    
    @Autowired
    private IRutaService iRutaService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroRuta")
    public String registroRuta(@Validated Ruta ruta, Model model) {

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

        return "formularios/formModeloRuta";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarRuta")
    public String RegistrarRuta(@Validated Ruta ruta) {
        ruta.setEstado_ruta("A");
        iRutaService.save(ruta);
        return "redirect:/ListasRuta";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarRuta/{id_ruta}")
    public String eliminarRuta(@PathVariable("id_ruta") Integer id_ruta) {

        Ruta ruta = iRutaService.findOne(id_ruta);
        ruta.setEstado_ruta("X");
        iRutaService.save(ruta);
        return "redirect:/ListasRuta";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/Listasruta")
    public String listarRuta(Model model) {

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

        return "listas/listaRuta";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/rol/{idRuta}")
    public String getContentRuta(@PathVariable(value = "idRuta") Integer idRuta, Model model,
            HttpServletRequest request) {

        model.addAttribute("ruta", iRutaService.findOne(idRuta));

        return "contentRuta :: contentRuta";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarRuta")
    public String getRuta(Model model) {

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentRuta :: contentRuta";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosRuta")
    public String guardarCambiosRuta(@ModelAttribute Ruta ruta) {
        ruta.setEstado_ruta("A");
        iRutaService.save(ruta);
        return "redirect:/ListasRuta";
    }
}
