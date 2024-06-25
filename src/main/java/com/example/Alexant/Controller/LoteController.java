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
    private IProveedorService iProveedorService;

    // ========= Formulario para registrar =========

    @GetMapping(value = "/formRegistroLote")
    public String registroLote(@Validated Lote lote, Model model) {
        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", iProveedorService.findAll());

        return "alexant/formLote"; /*No tenemos formularios todavía
     */
    }

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarLote")
    public String guardarLote(@Validated Lote lote) {
        lote.setEstado_lote("A");
        loteService.save(lote);
        return "redirect:/ListasLote"; /*No teneos listasVentas*/
    }

    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarLote/{id_lote}")
    public String eliminarLote(@PathVariable("id_lote") Integer id_lote) {
        Lote lote = loteService.findOne(id_lote);
        lote.setEstado_lote("A");
        loteService.save(lote);
        return "redirect:/ListasLote"; /*Falta el formulario*/ 

    }

    /*=============== LISTAR =====================*/

    @GetMapping(value = "/ListasLote")
    public String listarLote(Model model) {
        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", iProveedorService.findAll());

        return "listas/listaLote";/*Falta el formulario*/ 
    }

  
    /*=============== MODIFICAR =====================*/

    /* Modificación Modal */
    @RequestMapping(value = "/lote/{id_lote}")
    public String getContentLote(@PathVariable(value = "id_lote") Integer id_lote, Model model,
        HttpServletRequest request) {
        model.addAttribute("lote", loteService.findOne(id_lote));

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", iProveedorService.findAll());

        return "contentLote :: contentLote";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarLote")
    public String getRegistroLote(Model model) {
        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());
        
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", iProveedorService.findAll());
        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentLote :: contentLote"; /*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosLote")
    public String guardarCambiosLote(@ModelAttribute Lote lote) {
        lote.setEstado_lote("X");
        loteService.save(lote);
        return "redirect:/ListasLote";/*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // -------------------------------------------------
}
