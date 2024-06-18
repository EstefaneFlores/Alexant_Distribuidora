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

import com.example.Alexant.Models.entitys.Proveedor;
import com.example.Alexant.Models.service.service.IProveedorService;



import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProveedorController {
    
    @Autowired
    private IProveedorService iProveedorService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroProveedor")
    public String registroProveedor(@Validated Proveedor proveedor, Model model) {

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", iProveedorService.findAll());

        return "formularios/formModeloProveedor";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarProveedor")
    public String RegistrarProveedor(@Validated Proveedor proveedor) {
        proveedor.setEstado_proveedor("A");
        iProveedorService.save(proveedor);
        return "redirect:/ListasProveedor";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarProveedor/{id_proveedor}")
    public String eliminarProveedor(@PathVariable("id_proveedor") Integer id_proveedor) {

        Proveedor proveedor = iProveedorService.findOne(id_proveedor);
        proveedor.setEstado_proveedor("X");
        iProveedorService.save(proveedor);
        return "redirect:/ListasProveedor";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/Listasproveedor")
    public String listarproveedor(Model model) {

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", iProveedorService.findAll());

        return "listas/listaProveedor";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/proveedor/{idProveedor}")
    public String getContentProveedor(@PathVariable(value = "idProveedor") Integer idProveedor, Model model,
            HttpServletRequest request) {

        model.addAttribute("proveedor", iProveedorService.findOne(idProveedor));

        return "contentProveedor :: contentproveedor";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarProveedor")
    public String getRegistroProveedor(Model model) {

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", iProveedorService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentProveedor :: contentproveedor";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosProveedor")
    public String guardarCambiosProveedor(@ModelAttribute Proveedor proveedor) {
        proveedor.setEstado_proveedor("A");
        iProveedorService.save(proveedor);
        return "redirect:/ListasProveedor";
    }
}
