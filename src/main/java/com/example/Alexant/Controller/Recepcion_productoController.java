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

import com.example.Alexant.Models.entitys.Lote;
import com.example.Alexant.Models.entitys.Recepcion_Producto;
import com.example.Alexant.Models.service.service.ILoteService;
import com.example.Alexant.Models.service.service.IRecepcion_ProductoService;



import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Recepcion_productoController {
    
    @Autowired
    private IRecepcion_ProductoService iRecepcion_ProductoService;

    @Autowired
    private ILoteService iLoteService;

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarRecepcion_Producto")
    public String RegistrarRecepcion_Producto(@Validated Recepcion_Producto recepcion_producto, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("recepcion_producto", recepcion_producto);
        model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", iLoteService.findAll());
        
        return "redirect:/formRecepcionProducto";
    }
        
        recepcion_producto.setEstado_recepcion_producto("A");
        iRecepcion_ProductoService.save(recepcion_producto);
        return "redirect:/formRecepcionProducto";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarRecepcion_Producto/{id_registro}")
    public String eliminarRecepcion_Productor(@PathVariable("id_registro") Integer id_registro) {

        Recepcion_Producto recepcion_producto = iRecepcion_ProductoService.findOne(id_registro);
        recepcion_producto.setEstado_recepcion_producto("X");
        iRecepcion_ProductoService.save(recepcion_producto);
        return "redirect:/formRecepcionProducto";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/formRecepcionProducto")
    public String listarRecepcion_Producto(Model model) {

        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", iLoteService.findAll());

        return "FormRecepcionProducto";
    }

    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/registrarRecepcionProducto/{idRegistro}")
    public String getContentRecepcion_Producto(@PathVariable(value = "idRegistro") Integer idRegistro, Model model,
            HttpServletRequest request) {

        model.addAttribute("recepcion_producto", iRecepcion_ProductoService.findOne(idRegistro));

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", iLoteService.findAll());

        return "conten :: contentRecepcionProducto";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarRecepcionProducto")
    public String getRegistroRecepcion_Producto(Model model) {

        model.addAttribute("recepcion_producto", new Recepcion_Producto());
        model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", iLoteService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "conten :: contentRecepcionProducto";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosRecepcion_Producto")
    public String guardarCambiosRecepcion_Producto(@ModelAttribute Recepcion_Producto recepcion_producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("recepcion_producto", recepcion_producto);
            model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());

            model.addAttribute("lote", new Lote());
            model.addAttribute("lotes", iLoteService.findAll());
            return "redirect:/formRecepcionProducto";
        }
           
        recepcion_producto.setEstado_recepcion_producto("A");
        iRecepcion_ProductoService.save(recepcion_producto);
        return "redirect:/formRecepcionProducto";
    }
}
