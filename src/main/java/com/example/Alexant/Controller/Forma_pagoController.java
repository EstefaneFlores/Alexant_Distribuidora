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

import com.example.Alexant.Models.entitys.Forma_pago;
import com.example.Alexant.Models.service.service.IForma_pagoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Forma_pagoController {
    
    @Autowired
    private IForma_pagoService iForma_pagoService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroForma_pago")
    public String registroForma_pago(@Validated Forma_pago forma_pago, Model model) {

        model.addAttribute("forma_pago", new Forma_pago());
        model.addAttribute("forma_pagos", iForma_pagoService.findAll());

        return "formularios/formModeloForma_pago";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarForma_pago")
    public String RegistrarForma_pago(@Validated Forma_pago forma_pago) {
        forma_pago.setEstado_forma_pago("A");
        iForma_pagoService.save(forma_pago);
        return "redirect:/ListasForma_pago";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarForma_pago/{id_forma_pago}")
    public String eliminarRuta(@PathVariable("id_forma_pago") Integer id_forma_pago) {

        Forma_pago forma_pago = iForma_pagoService.findOne(id_forma_pago);
        forma_pago.setEstado_forma_pago("X");
        iForma_pagoService.save(forma_pago);
        return "redirect:/ListasRForma_pago";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/Listasforma_pago")
    public String listarForma_pago(Model model) {

        model.addAttribute("forma_pago", new Forma_pago());
        model.addAttribute("forma_pagos", iForma_pagoService.findAll());

        return "listas/listaforma_pago";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/forma_pago/{idForma_pago}")
    public String getContentForma_pago(@PathVariable(value = "idForma_pago") Integer idForma_pago, Model model,
            HttpServletRequest request) {

        model.addAttribute("forma_pago", iForma_pagoService.findOne(idForma_pago));

        return "contentForma_pago :: contentForma_pago";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarForma_pago")
    public String getForma_pago(Model model) {

        model.addAttribute("forma_pago", new Forma_pago());
        model.addAttribute("forma_pagos", iForma_pagoService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentForma_pago :: contentForma_pago";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosForma_pago")
    public String guardarCambiosForma_pago(@ModelAttribute Forma_pago forma_pago) {
        forma_pago.setEstado_forma_pago("A");
        iForma_pagoService.save(forma_pago);
        return "redirect:/ListasForma_pago";
    }
}
