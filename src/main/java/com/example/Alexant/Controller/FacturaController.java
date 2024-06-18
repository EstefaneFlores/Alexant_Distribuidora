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


import com.example.Alexant.Models.entitys.Factura;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IFacturaService;
import com.example.Alexant.Models.service.service.IVentaService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class FacturaController {

    @Autowired
    private IFacturaService iFacturaService;
    @Autowired
    private IVentaService iVentaService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroFactura")
    public String registroFactura(@Validated Factura factura, Model model) {

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", iFacturaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());


        return "formularios/formModeloFactura";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarFactura")
    public String RegistrarFactura(@Validated Factura factura) {

        factura.setEstado_fac("A");
        iFacturaService.save(factura);

        return "redirect:/ListasFactura";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarFactura/{id_factura}")
    public String eliminarFactura(@PathVariable("id_factura") Integer id_factura) {

        Factura factura = iFacturaService.findOne(id_factura);
        factura.setEstado_fac("X");
        iFacturaService.save(factura);

        return "redirect:/ListasFactura";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasDeFactura")
    public String listarFactura(Model model) {

       model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", iFacturaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());


        return "listas/listaFactura";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/factura/{idFactura}")
    public String getContentFactura(@PathVariable(value = "idFactura") Integer idFactura, Model model,
            HttpServletRequest request) {

              model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", iFacturaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());

        return "contentFactura :: contentfactura";

    }

    /* Registrar Factura model */
    @RequestMapping(value = "/registrarFactura")
    public String getRegistroFactura(Model model) {

           model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", iFacturaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());


        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentFactura :: contentfactura";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosFactura")
    public String guardarCambiosFactura(@ModelAttribute Factura factura) {
        factura.setEstado_fac("A");
        iFacturaService.save(factura);
        return "redirect:/ListasFactura";
    }

    // -------------------------------------------------
}
