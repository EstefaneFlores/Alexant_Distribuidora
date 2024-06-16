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

import Models.entitys.Cargo;
import Models.entitys.Categoria;
import Models.service.service.ICategoriaService;
import jakarta.servlet.http.HttpServletRequest;



@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaService iCategoriaService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroCategoria")
    public String registroCategoria(@Validated Categoria categoria, Model model) {

        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", iCategoriaService.findAll());

        return "formularios/formModeloCategoria";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarCategoria")
    public String RegistrarCategoria(@Validated Categoria categoria) {
        categoria.setEstado_categoria("A");
        iCategoriaService.save(categoria);
        return "redirect:/ListasCategoria";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarCategoria/{id_Categoria}")
    public String eliminarCategoria(@PathVariable("id_categoria") Integer id_categoria) {

        Categoria categoria = iCategoriaService.findOne(id_categoria);
        categoria.setEstado_categoria("X");
        iCategoriaService.save(categoria);
        return "redirect:/ListasCategoria";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasCategoria")
    public String listarCategoria(Model model) {

        model.addAttribute("Categoria", new Categoria());
        model.addAttribute("Categorias", iCategoriaService.findAll());

        return "listas/listaCategoria";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/categoria/{idCategoria}")
    public String getContentCategoria(@PathVariable(value = "idCategoria") Integer idCategoria, Model model,
            HttpServletRequest request) {

        model.addAttribute("categoria", iCategoriaService.findOne(idCategoria));

        return "contentCategoria :: contentcategoria";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarCategoria")
    public String getRegistroCategoria(Model model) {

        model.addAttribute("categoria", new Cargo());
        model.addAttribute("categorias", iCategoriaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentCategoria :: contentcategoria";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosCategoria")
    public String guardarCambiosCategoria(@ModelAttribute Categoria categoria) {
        categoria.setEstado_categoria("A");
        iCategoriaService.save(categoria);
        return "redirect:/ListasCategoria";
    }

    // -------------------------------------------------
}
