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

import com.example.Alexant.Models.entitys.Detalle_Factura;
import com.example.Alexant.Models.entitys.Factura;
import com.example.Alexant.Models.service.service.IDetalle_FacturaService;
import com.example.Alexant.Models.service.service.IFacturaService;
import com.example.Alexant.Models.entitys.Det_Venta;
import com.example.Alexant.Models.service.service.IDet_VentaService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Detalle_FacturaController {

    @Autowired
    private IDetalle_FacturaService iDetalle_FacturaService;
    @Autowired
    private IFacturaService iFacturaService;
    @Autowired
    private IDet_VentaService iDet_VentaService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroDetalle_Factura")
    public String registroDetalle_Factura(@Validated Detalle_Factura detalle_Factura, Model model) {

        model.addAttribute("detalle_Factura", new Detalle_Factura());
        model.addAttribute("detalle_Facturas", iDetalle_FacturaService.findAll());

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", iFacturaService.findAll());

         model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        return "formularios/formModeloDetalle_Factura";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarDetalle_Factura")
    public String RegistrarCliente(@Validated Detalle_Factura detalle_Factura) {

        detalle_Factura.setEstado_det_f("A");
        iDetalle_FacturaService.save(detalle_Factura);

        return "redirect:/ListasDetalle_Factura";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarDetalle_Factura/{id_Detalle_Factura}")
    public String eliminarDetalle_Factura(@PathVariable("id_detalle_Factura") Integer id_detalle_Factura) {

        Detalle_Factura detalle_Factura = iDetalle_FacturaService.findOne(id_detalle_Factura);
        detalle_Factura.setEstado_det_f("X");
        iDetalle_FacturaService.save(detalle_Factura);

        return "redirect:/ListasDetalle_Factura";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasDetalle_Factura")
    public String listarDetalle_Factura(Model model) {

        model.addAttribute("detalle_Factura", new Detalle_Factura());
        model.addAttribute("detalle_Facturas", iDetalle_FacturaService.findAll());

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", iFacturaService.findAll());

         model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        return "listas/listaDetalle_Factura";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/detalle_Factura/{idDetalle_Factura}")
    public String getContentDetalle_Factura(@PathVariable(value = "idDetalle_Factura") Integer idDetalle_Factura, Model model,
            HttpServletRequest request) {

                model.addAttribute("detalle_Factura", new Detalle_Factura());
                model.addAttribute("detalle_Facturas", iDetalle_FacturaService.findAll());
        
                model.addAttribute("factura", new Factura());
                model.addAttribute("facturas", iFacturaService.findAll());
        
                 model.addAttribute("det_Venta", new Det_Venta());
                model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        return "contentDetalle_Factura :: contentdetalle_Factura";

    }

    /* Registrar Detalle_Factura model */
    @RequestMapping(value = "/registrarDetalle_Factura")
    public String getRegistroDetalle_Factura(Model model) {

        model.addAttribute("detalle_Factura", new Detalle_Factura());
        model.addAttribute("detalle_Facturas", iDetalle_FacturaService.findAll());

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", iFacturaService.findAll());

         model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        return "contentDetalle_Factura :: contentdetalle_Factura";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDetalle_Factura")
    public String guardarCambiosDetalle_Factura(@ModelAttribute Detalle_Factura detalle_Factura) {
        detalle_Factura.setEstado_det_f("A");
        iDetalle_FacturaService.save(detalle_Factura);
        return "redirect:/ListasDetalle_Factura";
    }

    // -------------------------------------------------
}
