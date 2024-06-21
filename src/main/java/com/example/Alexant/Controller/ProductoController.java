package com.example.Alexant.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.Alexant.Models.entitys.Producto;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.ICategoriaService;
import com.example.Alexant.Models.service.service.IDet_VentaService;
import com.example.Alexant.Models.service.service.IProductoService;
import com.example.Alexant.Models.service.service.IProveedorService;
import com.example.Alexant.Models.service.service.IRecepcion_ProductoService;
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @Autowired
    private ICategoriaService iCategoriaService;

    @Autowired
    private IRecepcion_ProductoService iRecepcion_ProductoService;
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @Autowired
    private IProveedorService iProveedorService;

    @Autowired
    private IDet_VentaService det_VentaService;

    @GetMapping("/listar")
    public String listarProductos(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("userLog") != null) {
            model.addAttribute("productos", iProductoService.findAll());
            model.addAttribute("proveedores", iProveedorService.findAll());
            model.addAttribute("detallesVenta", det_VentaService.findAll());

            Usuario user = (Usuario) request.getSession().getAttribute("userLog");
            Usuario userLog = usuarioService.findOne(user.getId_usuario());
            model.addAttribute("userLog", userLog);
            return "listaProducto";
        } else {
            return "redirect:/aux";
        }
    }

    @RequestMapping(value = "/ver-producto/{id_producto}")
    public String verProducto(@PathVariable(value = "id_producto") Integer id_producto, Model model) {
        model.addAttribute("producto", iProductoService.findOne(id_producto));
        model.addAttribute("proveedores", iProveedorService.findAll());
        model.addAttribute("detallesVenta", det_VentaService.findAll());

        return "Usuarios/formularioProducto";
    }

    @RequestMapping(value = "/form-nuevo-producto")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("proveedores", iProveedorService.findAll());
        model.addAttribute("detallesVenta", det_VentaService.findAll());
        return "Usuarios/formularioProducto";
    }

    @GetMapping(value = "/formRegistroProducto")
    public String registroProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", iProductoService.findAll());
        model.addAttribute("proveedores", iProveedorService.findAll());
        model.addAttribute("detallesVenta", det_VentaService.findAll());

        return "FormProducto";
    }

    @RequestMapping(value = "/eliminarProducto/{id_producto}")
    public String eliminarProducto(@PathVariable("id_producto") Integer id_producto) {
        Producto producto = iProductoService.findOne(id_producto);
        producto.setEstado_pro("X");
        iProductoService.save(producto);
        return "redirect:/formRegistroProducto";
    }

    @RequestMapping(value = "/producto/{id_producto}")
    public String getContentProducto(@PathVariable(value = "id_producto") Integer id_producto, Model model) {
        model.addAttribute("producto", iProductoService.findOne(id_producto));
        model.addAttribute("proveedores", iProveedorService.findAll());
        return "Conten :: contentProducto";
    }

    @RequestMapping(value = "/registrarProducto")
    public String getRegistroProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", iProductoService.findAll());
        model.addAttribute("proveedores", iProveedorService.findAll());
        return "Conten :: contentProducto";
    }

    @PostMapping(value = "/guardarProducto")
    public String registrarProducto(@Validated Producto producto) {
        producto.setEstado_pro("A");
        iProductoService.save(producto);
        return "redirect:/formRegistroProducto";
    }

    @PostMapping(value = "/guardarCambiosProducto")
    public String guardarCambiosProducto(@ModelAttribute Producto producto) {
        producto.setEstado_pro("A");
        iProductoService.save(producto);
        return "redirect:/formRegistroProducto";
    }
}
