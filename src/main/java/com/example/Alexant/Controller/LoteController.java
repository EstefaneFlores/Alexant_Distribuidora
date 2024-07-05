package com.example.Alexant.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*; 
import com.example.Alexant.Models.entitys.Lote;
import com.example.Alexant.Models.entitys.Proveedor; 
import com.example.Alexant.Models.service.service.ILoteService;
import com.example.Alexant.Models.service.service.IProveedorService; 

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class LoteController {

    @Autowired
    private ILoteService loteService;

 

    @Autowired
    private IProveedorService proveedorService;

    
    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarLote")
    public String RegistrarLote(@Validated Lote lote, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("lote", lote);
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());
        
        return "redirect:/formAdministrarLote";
    }
    lote.setEstado_lote("A");
    loteService.save(lote);
        return "redirect:/formAdministrarLote";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarLote/{id_lote}")
    public String eliminarLote(@PathVariable("id_lote") Integer id_lote) {

        Lote lote = loteService.findOne(id_lote);
        lote.setEstado_lote("X");
        loteService.save(lote);
        return "redirect:/formAdministrarLote";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/formAdministrarLote")
    public String listarLote(Model model) {

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());
  
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());

        return "FormLote";
    }

    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/registrarLote/{idLote}")
    public String getContentLote(@PathVariable(value = "idLote") Integer idLote, Model model,
            HttpServletRequest request) {

        model.addAttribute("lote", loteService.findOne(idLote));
       
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());

        return "conten :: contentLote";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarLote")
    public String getRegistroLote(Model model) {

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());
 
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());

        return "conten :: contentLote";
    }

    // --------------------------------------------
 
    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosLote")
    public String guardarCambiosLote(@ModelAttribute Lote lote, BindingResult result, Model model) {
        if (result.hasErrors()) {
        model.addAttribute("lote", lote);
        model.addAttribute("lotes", loteService.findAll());
 
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());   
    
            return "redirect:/formAdministrarLote";
        }
           
        lote.setEstado_lote("A");
        loteService.save(lote);
        return "redirect:/formAdministrarLote";
    }
    
}
