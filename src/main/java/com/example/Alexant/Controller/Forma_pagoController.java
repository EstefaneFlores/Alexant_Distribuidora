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
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IForma_pagoService;
import com.example.Alexant.Models.service.service.IPersonaService;
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Forma_pagoController {
    @Autowired
    private IForma_pagoService forma_pagoService;
    @Autowired
    private IPersonaService iPersonaService;
    @Autowired
    private IUsuarioService usuarioService;


    /*Listar persona */

    @RequestMapping(value = "/listar_forma_pago")
    public String listar(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("userLog") != null) {
            model.addAttribute("personas", iPersonaService.findAll());
            
            // Persona pers = (Persona) request.getSession().getAttribute("userLog");

            Usuario user = (Usuario) request.getSession().getAttribute("userLog");
            Usuario userLog = usuarioService.findOne(user.getId_usuario());
            model.addAttribute("userLog", userLog);
            return "listaFormaPago";
        } else {
            return "redirect: /Alexant/aux";
        }
    }

    @RequestMapping(value = "/ver-formaPago2/{id_forma_pago}")
	public String verFormaPago(@PathVariable(value = "id_forma_pago") Integer id_forma_pago, Model model) {
		model.addAttribute("forma_pago", forma_pagoService.findOne(id_forma_pago));
		model.addAttribute("modal", "true");
		return "Usuarios/formularioFormaPago";
	}

    @RequestMapping(value = "/form-nuevo-formaPago")
	public String nuevaFormaPago(Model model) {
		model.addAttribute("forma_pago", new Forma_pago());
		return "Usuarios/formularioFormaPago";
	}


    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroFormaPago")
    public String registrarFormaPago(@Validated Forma_pago forma_pago, Model model) {

        model.addAttribute("forma_pago", new Forma_pago());
        model.addAttribute("forma_pagos", forma_pagoService.findAll());

        return "FormFormaPago";
    }

  

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarFormaPago/{id_forma_pago}")
    public String eliminarFormaPago(@PathVariable("id_forma_pago") Integer id_forma_pago) {

        Forma_pago forma_pago = forma_pagoService.findOne(id_forma_pago);
        forma_pago.setEstado_forma_pago("X");
        forma_pagoService.save(forma_pago);
        return "redirect:/formRegistroFormaPago";

    }

    // --------------------------------------------
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/forma_pago/{id_forma_pago}")
    public String getContentFormaPago(@PathVariable(value = "id_forma_pago") Integer id_forma_pago, Model model,
            HttpServletRequest request) {

        model.addAttribute("forma_pago", forma_pagoService.findOne(id_forma_pago));

        return "Conten :: contentFormaPago";

    }

    /* -----------REGISTRAR FORMA PAGO------------ */

    @RequestMapping(value = "/registrarFormaPago")
    public String getRegistroFormaPago(Model model) {

        model.addAttribute("forma_pago", new Forma_pago());
        model.addAttribute("forma_pagos", forma_pagoService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "Conten :: contentFormaPago";
    }

      /* ------------- GUARDAR ------------ */

      @PostMapping(value = "/guardarForma_pago")
      public String RegistrarFormaPago(@Validated Forma_pago forma_pago) {
  
        forma_pago.setEstado_forma_pago("A");
        forma_pagoService.save(forma_pago);
  
          return "redirect:/formRegistroFormaPago";
  
      }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosFormaPago")
    public String guardarCambiosFormaPago(@ModelAttribute Forma_pago forma_pago) {
        forma_pago.setEstado_forma_pago("A");
        forma_pagoService.save(forma_pago);
        return "redirect:/formRegistroFormaPago";
    }
    
}