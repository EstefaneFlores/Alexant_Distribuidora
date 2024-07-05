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
import com.example.Alexant.Models.entitys.Detalle_Factura;
import com.example.Alexant.Models.entitys.Factura;
import com.example.Alexant.Models.service.service.IDetalle_FacturaService;
import com.example.Alexant.Models.service.service.IFacturaService;
import com.example.Alexant.Models.entitys.Det_Venta;
import com.example.Alexant.Models.service.service.IDet_VentaService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Detalle_FacturaController {

    @Autowired
    private IDetalle_FacturaService detalle_FacturaService;
    @Autowired
    private IFacturaService facturaService;
    @Autowired
    private IDet_VentaService iDet_VentaService;
 /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarDetalleFactura")
    public String RegistrarDetalleFactura(@Validated Detalle_Factura detalle_Factura, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("detalleFactura", detalle_Factura);
        model.addAttribute("detalleFacturas", detalle_FacturaService.findAll());

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());

        model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        return "redirect:/formAdministrarDetalleFactura";
    }
    detalle_Factura.setEstado_det_f("A");
    detalle_FacturaService.save(detalle_Factura);
        return "redirect:/formAdministrarDetalleFactura";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminaDetalleFactura/{id_detalleFactura}")
    public String eliminarDetalleFactura(@PathVariable("id_detalleFactura") Integer id_detalleFactura) {

        Detalle_Factura detalle_Factura = detalle_FacturaService.findOne(id_detalleFactura);
        detalle_Factura.setEstado_det_f("X");
        detalle_FacturaService.save(detalle_Factura);
        return "redirect:/formAdministrarDetalleFactura";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/formAdministrarDetalleFactura")
    public String listarDetalleFactura(Model model) {

        model.addAttribute("detalleFactura", new Detalle_Factura());
        model.addAttribute("detalleFacturas", detalle_FacturaService.findAll());

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());

        model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        return "formDetalleFactura";
    }

    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/registrarDetalleFactura/{idDetalleFactura}")
    public String getContentDetalleFactura(@PathVariable(value = "idDetalleFactura") Integer idDetalleFactura, Model model,
            HttpServletRequest request) {

        model.addAttribute("detalleFactura", detalle_FacturaService.findOne(idDetalleFactura));

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());

        model.addAttribute("det_venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        return "conten :: contentDetalleFactura";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarDetalleFactura")
    public String getRegistroDetalleFactura(Model model) {

        model.addAttribute("detalleFactura", new Detalle_Factura());
        model.addAttribute("detalleFacturas", detalle_FacturaService.findAll());

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());

        model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        return "conten :: contentDetalleFactura";
    }

    // --------------------------------------------
 
    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDetalleFactura")
    public String guardarCambiosDetalleFactura(@ModelAttribute Detalle_Factura detalle_Factura, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("detalleFactura", detalle_Factura);
            model.addAttribute("detalleFacturas", detalle_FacturaService.findAll());

            model.addAttribute("factura", new Factura());
            model.addAttribute("facturas", facturaService.findAll());
    
            model.addAttribute("det_Venta", new Det_Venta());
            model.addAttribute("det_Ventas", iDet_VentaService.findAll());  
    
            return "redirect:/formAdministrarDetalleFactura";
        }
           
        detalle_Factura.setEstado_det_f("A");
        detalle_FacturaService.save(detalle_Factura);
        return "redirect:/formAdministrarDetalleFactura";
    }
}
