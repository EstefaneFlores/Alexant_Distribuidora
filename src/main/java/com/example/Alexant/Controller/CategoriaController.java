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
import com.example.Alexant.Models.entitys.Categoria;
import com.example.Alexant.Models.entitys.Producto;
import com.example.Alexant.Models.service.service.ICategoriaService;
import com.example.Alexant.Models.service.service.IProductoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaService iCategoriaService;

    @Autowired
    private IProductoService productoService;

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarCategoria")
    public String RegistrarCategoria(@Validated Categoria categoria, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("categoria", categoria);
        model.addAttribute("categorias", iCategoriaService.findAll());
     
        model.addAttribute("productos", productoService.findAll());
        
        return "redirect:/formAdministrarCategoria";
    }
    categoria.setEstado_categoria("A");
    iCategoriaService.save(categoria);
        return "redirect:/formAdministrarCategoria";

    }


    /*--------------- ELIMINAR -----------*/

    @RequestMapping(value = "/eliminarCategoria/{id_categoria}")
    public String eliminarCategoria(@PathVariable("id_categoria") Integer id_categoria) {
        Categoria categoria = iCategoriaService.findOne(id_categoria);
        categoria.setEstado_categoria("X");
        iCategoriaService.save(categoria);
        return "redirect:/formAdministrarCategoria";

    }


    /* --------------- LISTA ----------------- */

    @GetMapping(value = "/formAdministrarCategoria")
    public String listarCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", iCategoriaService.findAll());
      
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", productoService.findAll());

        return "formCategoria";
    }

    // -----------Para las modificaciones---------------

    @RequestMapping(value = "/registrarCategoria/{idCategoria}")
    public String getContentCategoria(@PathVariable(value = "idCategoria") Integer idCategoria, Model model,
            HttpServletRequest request) {
        model.addAttribute("categoria", iCategoriaService.findOne(idCategoria));

        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", productoService.findAll());

        return "conten :: contentCategoria";
    }

    /* Registrar model */
    @RequestMapping(value = "/registrarCategoria")
    public String getRegistroCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", iCategoriaService.findAll());
       
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", productoService.findAll());

        return "conten :: contentCategoria";
    }

    // ------------------Guardar Cambios--------------------
 
    @PostMapping(value = "/guardarCambiosCategoria")
    public String guardarCambiosCategoria(@ModelAttribute Categoria categoria, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categoria", categoria);
            model.addAttribute("categorias", iCategoriaService.findAll());
          
            model.addAttribute("producto", new Producto());
            model.addAttribute("productos", productoService.findAll());    
    
            return "redirect:/formAdministrarCategoria";
        }
           
        categoria.setEstado_categoria("A");
        iCategoriaService.save(categoria);
        return "redirect:/formAdministrarCategoria";
    }
}
