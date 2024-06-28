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
import org.springframework.web.bind.annotation.RestController;

import com.example.Alexant.Models.entitys.Detalle_Factura;
import com.example.Alexant.Models.entitys.Factura;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IDetalle_FacturaService;
import com.example.Alexant.Models.service.service.IFacturaService;
import com.example.Alexant.Models.service.service.IVentaService;
import jakarta.servlet.http.HttpServletRequest;
@Controller
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;
    @Autowired
    private IDetalle_FacturaService detalle_FacturaService;
    @Autowired
    private IVentaService iVentaService;

  /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarFactura")
    public String RegistrarFactura(@Validated Factura factura, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("factura", factura);
        model.addAttribute("facturas", facturaService.findAll());

        model.addAttribute("detalle_Facturas", detalle_FacturaService.findAll());
        model.addAttribute("ventas", iVentaService.findAll());

        
        return "redirect:/formAdministrarFactura";
    }
    factura.setEstado_fac("A");
    facturaService.save(factura);
        return "redirect:/formAdministrarFactura";

    }

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarFactura/{id_factura}")
    public String eliminarFactura(@PathVariable("id_factura") Integer id_factura) {

        Factura factura = facturaService.findOne(id_factura);
        factura.setEstado_fac("X");
        facturaService.save(factura);
        return "redirect:/formAdministrarFactura";

    }

    /* ------------ Lista ----------------- */
    @GetMapping(value = "/formAdministrarFactura")
    public String listarFactura(Model model){
    
     model.addAttribute("factura", new Factura());
     model.addAttribute("facturas", facturaService.findAll());

     model.addAttribute("detalle_Factura", new Detalle_Factura());
     model.addAttribute("detalle_Facturas", detalle_FacturaService.findAll());
        
     model.addAttribute("venta", new Venta());
     model.addAttribute("ventas", iVentaService.findAll());

     return "formFactura";
    }


    /* Modificación Modal */
    @RequestMapping(value = "/registrarFactura/{idFactura}")
    public String getContentFactura(@PathVariable(value = "idFactura") Integer idFactura, Model model,
            HttpServletRequest request) {

        model.addAttribute("factura", facturaService.findOne(idFactura));

        model.addAttribute("detalle_Factura", new Detalle_Factura());
        model.addAttribute("detalle_Facturas", detalle_FacturaService.findAll());
        
        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());

        return "conten :: contentFactura";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarFactura")
    public String getRegistroFactura(Model model) {

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());

        model.addAttribute("detalle_Factura", new Detalle_Factura());
        model.addAttribute("detalle_Facturas", detalle_FacturaService.findAll());
        
        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());

        return "conten :: contentFactura";
    }

    // --------------------------------------------
 
    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosFactura")
    public String guardarCambiosFactura(@ModelAttribute Factura factura, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("factura", factura);
            model.addAttribute("facturas", facturaService.findAll());

            model.addAttribute("detalle_Factura", new Detalle_Factura());
            model.addAttribute("detalle_Facturas", detalle_FacturaService.findAll());
            
            model.addAttribute("venta", new Venta());
            model.addAttribute("ventas", iVentaService.findAll()); 
    
            return "redirect:/formAdministrarFactura";
        }
           
        factura.setEstado_fac("A");
        facturaService.save(factura);
        return "redirect:/formAdministrarFactura";
    }
}
