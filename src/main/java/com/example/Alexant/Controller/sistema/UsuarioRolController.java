package com.example.Alexant.Controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Alexant.Models.entitys.UsuarioRol;
import com.example.Alexant.Models.service.service.IUsuarioRolService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UsuarioRolController {

    @Autowired
    private IUsuarioRolService usuarioRolService;

    // ========= Formulario para registrar =========

    @GetMapping(value = "/formRegistroUsuarioRol")
    public String registroVenta(@Validated UsuarioRol usuarioRol, Model model) {

        model.addAttribute("usuarioRol", new UsuarioRol());
        model.addAttribute("usuarioRols", usuarioRolService.findAll());

        return "alexant/formUsuarioRol"; /*No tenemos formularios todavía
     */
    }

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarUsuarioRol")
    public String guardarUsuarioRol(@Validated UsuarioRol usuarioRol) {
        usuarioRol.setEstado_usr_rol(1);
        usuarioRolService.save(usuarioRol);
        return "redirect:/ListasUsuarioRol"; /*No teneos listasVentas*/
    }

    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarUsuarioRol/{id_usuario_rol}")
    public String eliminarUsuarioRol(@PathVariable("id_usuario_rol") Integer id_usuario_rol) {

        UsuarioRol usuarioRol = usuarioRolService.findOne(id_usuario_rol);
        usuarioRol.setEstado_usr_rol(0);
        usuarioRolService.save(usuarioRol);
        return "redirect:/ListasUsuarioRol"; /*Falta el formulario*/ 

    }

    /*=============== LISTAR =====================*/

    @GetMapping(value = "/ListasUsuarioRol")
    public String listarUsuarioRol(Model model) {

        model.addAttribute("usuarioRol", new UsuarioRol());
        model.addAttribute("usuarioRols", usuarioRolService.findAll());

        return "listas/listaUsuarioRol";/*Falta el formulario*/ 
    }

  
    /*=============== MODIFICAR =====================*/

    /* Modificación Modal */
    @RequestMapping(value = "/usuarioRol/{id_usuario_rol}")
    public String getContentUsuarioRol(@PathVariable(value = "id_usuario_rol") Integer id_usuario_rol, Model model,
        HttpServletRequest request) {

        model.addAttribute("usuarioRol", usuarioRolService.findOne(id_usuario_rol));

        return "contentDip :: contentVenta";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarUsuarioRol")
    public String getRegistroUsuarioRol(Model model) {

        model.addAttribute("usuarioRol", new UsuarioRol());
        model.addAttribute("usuarioRols", usuarioRolService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentUsuarioRol :: contentUsuarioRol"; /*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosUsuarioRol")
    public String guardarCambiosUsuarioRol(@ModelAttribute UsuarioRol usuarioRol) {
        usuarioRol.setEstado_usr_rol(1);
        usuarioRolService.save(usuarioRol);
        return "redirect:/ListasUsuarioRol";/*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // -------------------------------------------------
}
