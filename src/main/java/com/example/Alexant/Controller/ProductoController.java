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

import com.example.Alexant.Models.entitys.Categoria;
import com.example.Alexant.Models.entitys.Producto;
import com.example.Alexant.Models.entitys.Recepcion_Producto;
import com.example.Alexant.Models.service.service.ICategoriaService;
import com.example.Alexant.Models.service.service.IProductoService;
import com.example.Alexant.Models.service.service.IRecepcion_ProductoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductoController {
    
    @Autowired
    private IProductoService iProductoService;

    @Autowired
    private ICategoriaService iCategoriaService;

    @Autowired
    private IRecepcion_ProductoService iRecepcion_ProductoService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroProducto")
    public String registroProducto(@Validated Producto producto, Model model) {

        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", iProductoService.findAll());

        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", iCategoriaService.findAll());

        model.addAttribute("recepcion_Producto", new Recepcion_Producto());
        model.addAttribute("recepcion_Productos", iRecepcion_ProductoService.findAll());

        return "formularios/formModeloProducto";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarProducto")
    public String RegistrarProducto(@Validated Producto producto) {
        producto.setEstado_pro("A");
        iProductoService.save(producto);
        return "redirect:/ListasProducto";

    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarProducto/{id_producto}")
    public String eliminarProducto(@PathVariable("id_producto") Integer id_producto) {

        Producto producto = iProductoService.findOne(id_producto);
        producto.setEstado_pro("X");
        iProductoService.save(producto);
        return "redirect:/ListasProducto";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/Listasproducto")
    public String listarproducto(Model model) {

        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", iProductoService.findAll());

        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", iCategoriaService.findAll());

        model.addAttribute("recepcion_Producto", new Recepcion_Producto());
        model.addAttribute("recepcion_Productos", iRecepcion_ProductoService.findAll());


        return "listas/listaProducto";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/producto/{idProducto}")
    public String getContentProducto(@PathVariable(value = "idProducto") Integer idProducto, Model model,
            HttpServletRequest request) {

        model.addAttribute("producto", iProductoService.findOne(idProducto));
        
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", iCategoriaService.findAll());

        model.addAttribute("recepcion_Producto", new Recepcion_Producto());
        model.addAttribute("recepcion_Productos", iRecepcion_ProductoService.findAll());


        return "contentProducto :: contentproducto";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarProducto")
    public String getRegistroProducto(Model model) {

        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", iProductoService.findAll());

        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", iCategoriaService.findAll());

        model.addAttribute("recepcion_Producto", new Recepcion_Producto());
        model.addAttribute("recepcion_Productos", iRecepcion_ProductoService.findAll());


        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentProducto :: contentproducto";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosPreducto")
    public String guardarCambiosProducto(@ModelAttribute Producto producto) {
        producto.setEstado_pro("A");
        iProductoService.save(producto);
        return "redirect:/ListasProducto";
    }
}
