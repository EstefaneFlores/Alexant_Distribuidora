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

import com.example.Alexant.Models.entitys.Biene;
import com.example.Alexant.Models.entitys.Det_Venta;
import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IDet_VentaService;
import com.example.Alexant.Models.service.service.IVentaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Det_VentaController {
    
    @Autowired
    private IDet_VentaService iDet_VentaService;

     @Autowired
    private IVentaService iVentaService;

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarDet_Venta")
    public String RegistrarDet_Venta(@Validated Det_Venta det_Venta, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        model.addAttribute("ventas", iVentaService.findAll());
        
        return "redirect:/formAdministrarDetVenta";
    }
    det_Venta.setEstado_det_venta("A");
    iDet_VentaService.save(det_Venta);
        return "redirect:/formAdministrarDetVenta";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarDet_Venta/{id_det_Venta}")
    public String eliminarDet_Venta(@PathVariable("id_det_Venta") Integer id_det_Venta) {

        Det_Venta det_Venta = iDet_VentaService.findOne(id_det_Venta);
        det_Venta.setEstado_det_venta("X");
        iDet_VentaService.save(det_Venta);
        return "redirect:/formAdministrarDetVenta";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/formAdministrarDetVenta")
    public String listarDet_Venta(Model model) {

        model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iDet_VentaService.findAll());

        return "FormDetVenta";
    }

    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/registrarDetVenta/{idDet_Venta}")
    public String getContentDet_Venta(@PathVariable(value = "idDet_Venta") Integer idDet_Venta, Model model,
            HttpServletRequest request) {

        model.addAttribute("det_Venta", iDet_VentaService.findOne(idDet_Venta));

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());

        return "conten :: contentDet_Venta";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarDetVenta")
    public String getRegistroDet_Venta(Model model) {

        model.addAttribute("det_Venta", new Det_Venta());
        model.addAttribute("det_Ventas", iDet_VentaService.findAll());

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());

        return "conten :: contentDet_Venta";
    }

    // --------------------------------------------
 
    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDetVenta")
    public String guardarCambiosDet_Venta(@ModelAttribute Det_Venta det_Venta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("det_Venta", new Det_Venta());
            model.addAttribute("det_Venta", iDet_VentaService.findAll());

            model.addAttribute("venta", new Venta());
            model.addAttribute("ventas", iVentaService.findAll());    
    
            return "redirect:/formAdministrarDetVenta";
        }
           
        det_Venta.setEstado_det_venta("A");
        iDet_VentaService.save(det_Venta);
        return "redirect:/formAdministrarDetVenta";
    }
}
