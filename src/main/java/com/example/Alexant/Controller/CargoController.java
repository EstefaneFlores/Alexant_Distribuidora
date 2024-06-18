package com.example.Alexant.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Alexant.Models.entitys.Cargo;
import com.example.Alexant.Models.service.service.ICargoService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CargoController {

    @Autowired
    private ICargoService iCargoService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroCargo")
    public String registroCargo(@Validated Cargo cargo, Model model) {

        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", iCargoService.findAll());

        return "formularios/formModeloCargo";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarCargo")
    public String RegistrarCargo(@Validated Cargo cargo) {
        cargo.setEstado_cargo("A");
        iCargoService.save(cargo);
        return "redirect:/ListasCargo";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarCargo/{id_cargo}")
    public String eliminarCargo(@PathVariable("id_cargo") Integer id_cargo) {

        Cargo cargo = iCargoService.findOne(id_cargo);
        cargo.setEstado_cargo("X");
        iCargoService.save(cargo);
        return "redirect:/ListasCargo";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasCargo")
    public String listarCargo(Model model) {

        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", iCargoService.findAll());

        return "listas/listaCargo";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/cargo/{idCargo}")
    public String getContentCargo(@PathVariable(value = "idCargo") Integer idCargo, Model model,
            HttpServletRequest request) {

        model.addAttribute("cargo", iCargoService.findOne(idCargo));

        return "contentCargo :: contentcargo";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarCargo")
    public String getRegistroCargo(Model model) {

        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", iCargoService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentCargo :: contentcargo";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDip")
    public String guardarCambiosCargo(@ModelAttribute Cargo cargo) {
        cargo.setEstado_cargo("A");
        iCargoService.save(cargo);
        return "redirect:/ListasCargo";
    }

    // -------------------------------------------------
}
