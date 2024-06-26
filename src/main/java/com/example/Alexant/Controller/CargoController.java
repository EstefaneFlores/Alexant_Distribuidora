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

import com.example.Alexant.Models.entitys.Cargo;
import com.example.Alexant.Models.service.service.ICargoService;



import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CargoController {
    
    @Autowired
    private ICargoService iCargoService;

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarCargo")
    public String RegistrarCargo(@Validated Cargo cargo, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("cargo", cargo);
        model.addAttribute("cargos", iCargoService.findAll());
        
        return "redirect:/formAdministrarCargo";
    }
    cargo.setEstado_cargo("A");
    iCargoService.save(cargo);
        return "redirect:/formAdministrarCargo";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarCargo/{id_cargo}")
    public String eliminarCargo(@PathVariable("id_cargo") Integer id_cargo) {

        Cargo cargo = iCargoService.findOne(id_cargo);
        cargo.setEstado_cargo("X");
        iCargoService.save(cargo);
        return "redirect:/formAdministrarCargo";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/formAdministrarCargo")
    public String listarCargo(Model model) {

        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", iCargoService.findAll());

        return "formCargo";
    }

    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/registrarCargo/{idCargo}")
    public String getContentCargo(@PathVariable(value = "idCargo") Integer idCargo, Model model,
            HttpServletRequest request) {

        model.addAttribute("cargo", iCargoService.findOne(idCargo));

        return "conten :: contentCargo";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarCargo")
    public String getRegistroCargo(Model model) {

        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", iCargoService.findAll());


       
        return "conten :: contentCargo";
    }

    // --------------------------------------------
 
    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosCargo")
    public String guardarCambiosCargo(@ModelAttribute Cargo cargo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cargo", cargo);
            model.addAttribute("cargos", iCargoService.findAll());
    
            return "redirect:/formAdministrarCargo";
        }
           
        cargo.setEstado_cargo("A");
        iCargoService.save(cargo);
        return "redirect:/formAdministrarCargo";
    }
}
