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


import com.example.Alexant.Models.entitys.Det_Venta;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IDet_VentaService;
import com.example.Alexant.Models.service.service.IVentaService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Det_VentaController {

    @Autowired
    private IDet_VentaService iDet_VentaService;
    @Autowired
    private IVentaService iVentaService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroDet_Venta")
    public String registroDet_Venta(@Validated Det_Venta det_Venta, Model model) {

        model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("Det_Ventas", iDet_VentaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());


        return "formularios/formModeloDet_Venta";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarDet_Venta")
    public String RegistrarDet_Venta(@Validated Det_Venta det_Venta) {

        det_Venta.setEstado_det_venta("A");
        iDet_VentaService.save(det_Venta);

        return "redirect:/ListasDet_Venta";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarDet_Venta/{id_det_Venta}")
    public String eliminarDet_Venta(@PathVariable("id_det_Venta") Integer id_det_Venta) {

        Det_Venta det_Venta = iDet_VentaService.findOne(id_det_Venta);
        det_Venta.setEstado_det_venta("X");
        iDet_VentaService.save(det_Venta);

        return "redirect:/ListasDet_Venta";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasDet_Venta")
    public String listarDet_Venta(Model model) {

       model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());


        return "listas/listaDet_Venta";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/det_Venta/{idDet_Venta}")
    public String getContentDet_Venta(@PathVariable(value = "idDet_Venta") Integer idDet_Venta, Model model,
            HttpServletRequest request) {

              model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());

        return "contentDet_Venta :: contentdet_Venta";

    }

    /* Registrar Det_Venta model */
    @RequestMapping(value = "/registrarDet_Venta")
    public String getRegistroDet_Venta(Model model) {

           model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());


        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentDet_Venta :: contentdet_Venta";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDet_Venta")
    public String guardarCambiosDet_Venta(@ModelAttribute Det_Venta det_Venta) {
        det_Venta.setEstado_det_venta("A");
        iDet_VentaService.save(det_Venta);
        return "redirect:/ListasCliente";
    }

    // -------------------------------------------------
}
