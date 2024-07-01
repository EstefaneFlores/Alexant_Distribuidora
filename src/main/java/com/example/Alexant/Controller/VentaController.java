
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

import com.example.Alexant.Models.entitys.Cliente;
import com.example.Alexant.Models.entitys.Factura;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IClienteService;
import com.example.Alexant.Models.service.service.IFacturaService;
import com.example.Alexant.Models.service.service.IUsuarioService;
import com.example.Alexant.Models.service.service.IVentaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class VentaController {
    @Autowired
    private IVentaService iVentaService;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IClienteService iClienteService;
    @Autowired
    private IFacturaService facturaService;


    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarVenta")
    public String RegistrarVenta(@Validated Venta venta, BindingResult result, Model model) {
    // if (result.hasErrors()) {

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());
        
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());
        
        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());
        
    //     return "redirect:/formAdministrarVenta";
    // }
    venta.setEstado_venta("A");
    iVentaService.save(venta);
        return "redirect:/formAdministrarVenta";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarVenta/{id_venta}")
    public String eliminarVenta(@PathVariable("id_venta") Integer id_venta) {

        Venta venta = iVentaService.findOne(id_venta);
        venta.setEstado_venta("X");
        iVentaService.save(venta);
        return "redirect:/formAdministrarVenta";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/formAdministrarVenta")
    public String listarVenta(Model model) {

        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", iVentaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());

        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());

        return "formVenta";
    }

    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/registrarVenta/{idVenta}")
    public String getContentVenta(@PathVariable(value = "idVenta") Integer idVenta, Model model,
            HttpServletRequest request) {

        model.addAttribute("venta", iVentaService.findOne(idVenta));

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());
        
        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());
        return "conten :: contentVenta1";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarVenta")
    public String getRegistroVenta(Model model) {

        model.addAttribute("venta",  new Venta());
        model.addAttribute("ventas", iVentaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());
        
        model.addAttribute("factura", new Factura());
        model.addAttribute("facturas", facturaService.findAll());
       
        return "conten :: contentVenta1";
    }

    // --------------------------------------------
 
    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosVenta")
    public String guardarCambiosVenta(@ModelAttribute Venta venta, BindingResult result, Model model) {
       
        if (result.hasErrors()) {
            model.addAttribute("venta", venta);
            model.addAttribute("ventas", iVentaService.findAll());
    
            return "redirect:/formAdministrarVenta";
        }
           
        venta.setEstado_venta("A");
        iVentaService.save(venta);
        return "redirect:/formAdministrarVenta";
    }
}
