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

import Models.entitys.Recepcion_Producto;
import Models.service.service.IRecepcion_ProductoService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Recepcion_productoController {
    
    @Autowired
    private IRecepcion_ProductoService iRecepcion_ProductoService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroRecepcion_Producto")
    public String registroRecepcion_Producto(@Validated Recepcion_Producto recepcion_producto, Model model) {

        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());

        return "formularios/formModeloRecepcion_Producto";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarRecepcion_Producto")
    public String RegistrarRecepcion_Producto(@Validated Recepcion_Producto recepcion_producto) {
        recepcion_producto.setEstado_recepcion_producto("A");
        iRecepcion_ProductoService.save(recepcion_producto);
        return "redirect:/ListasRecepcion_Producto";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarRecepcion_Producto/{id_registro}")
    public String eliminarRecepcion_Productor(@PathVariable("id_registro") Integer id_registro) {

        Recepcion_Producto recepcion_producto = iRecepcion_ProductoService.findOne(id_registro);
        recepcion_producto.setEstado_recepcion_producto("X");
        iRecepcion_ProductoService.save(recepcion_producto);
        return "redirect:/ListasRecepcion_Producto";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasRecepcion_Producto")
    public String listarRecepcion_Producto(Model model) {

        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());

        return "listas/listaRecepcion_Producto";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/Recepcion_Producto/{idRegistro}")
    public String getContentRecepcion_Producto(@PathVariable(value = "idRegistro") Integer idRegistro, Model model,
            HttpServletRequest request) {

        model.addAttribute("Recepcion_Producto", iRecepcion_ProductoService.findOne(idRegistro));

        return "contentRecepcion_Producto :: contentRecepcion_Producto";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarRecepcion_Producto")
    public String getRegistroRecepcion_Producto(Model model) {

        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentRecepcion_Producto :: contentpRecepcion_Producto";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosRecepcion_Producto")
    public String guardarCambiosRecepcion_Producto(@ModelAttribute Recepcion_Producto recepcion_producto) {
        recepcion_producto.setEstado_recepcion_producto("A");
        iRecepcion_ProductoService.save(recepcion_producto);
        return "redirect:/ListasRecepcion_Producto";
    }
}
