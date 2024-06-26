package com.example.Alexant.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.Alexant.Models.entitys.Detalle_lote;
import com.example.Alexant.Models.entitys.Lote;
import com.example.Alexant.Models.entitys.Proveedor;
import com.example.Alexant.Models.entitys.Recepcion_Producto;
import com.example.Alexant.Models.service.service.IDetalleLoteServicee;
import com.example.Alexant.Models.service.service.ILoteService;
import com.example.Alexant.Models.service.service.IProveedorService;
import com.example.Alexant.Models.service.service.IRecepcion_ProductoService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class LoteController {

    @Autowired
    private ILoteService loteService;

    @Autowired
    private IDetalleLoteServicee detalleLoteService;

    @Autowired
    private IRecepcion_ProductoService recepcionProductoService;

    @Autowired
    private IProveedorService proveedorService;

    
    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarLote")
    public String RegistrarLote(@Validated Lote lote, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("lote", lote);
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("detalleLotes", detalleLoteService.findAll());
        model.addAttribute("recepcion_productos", recepcionProductoService.findAll());
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

        model.addAttribute("detalleLote", new Detalle_lote());
        model.addAttribute("detalleLotes", detalleLoteService.findAll());
        
        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", recepcionProductoService.findAll());

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

        model.addAttribute("detalleLote", new Detalle_lote());
        model.addAttribute("detalleLotes", detalleLoteService.findAll());
        
        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", recepcionProductoService.findAll());

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());

        return "conten :: contentLote";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarLote")
    public String getRegistroLote(Model model) {

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("detalleLote", new Detalle_lote());
        model.addAttribute("detalleLotes", detalleLoteService.findAll());

        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", recepcionProductoService.findAll());

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

        model.addAttribute("detalleLote", new Detalle_lote());
        model.addAttribute("detalleLotes", detalleLoteService.findAll());
        
        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", recepcionProductoService.findAll());

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());   
    
            return "redirect:/formAdministrarLote";
        }
           
        lote.setEstado_lote("A");
        loteService.save(lote);
        return "redirect:/formAdministrarLote";
    }
    
}
