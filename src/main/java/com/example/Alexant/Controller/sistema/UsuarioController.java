package com.example.Alexant.Controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IPersonaService;
import com.example.Alexant.Models.service.service.IUsuarioService;

@RestController
@RequestMapping("/sistema/usuario")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPersonaService personaService;

    @GetMapping(value = "/formUs")
    public String vistaUs(Model model, @Validated Usuario usuarios) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());


        return "usuarios";
    }

    // -------------------------GUARDAR---------------------------------------

    @PostMapping(value = "/saveUs")
    public String saveUsiario(@Validated Usuario usuarios) {

        usuarios.setEstado_usuario(1);

        usuarioService.save(usuarios);

        return "redirect:/listaUs";

    }

    // -------------------------LISTAR---------------------------------------

    @GetMapping(value = "/listaUs")
    public String listaUs(Model model, @Validated Usuario usuarios) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        return "listas/listaUs";

    }
// 
    // -------------------------EDITAR---------------------------------------

    @GetMapping(value = "/editarUs/{idUsuario}")
    public String editarUs(Model model, @PathVariable("idUsuario") Integer idUsuario) {

        Usuario usuario = usuarioService.findOne(idUsuario);

        usuario.setEstado_usuario(1);

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        return "redirect:/listaUs";
    }

    // -------------------------ELIMINAR---------------------------------------

    @GetMapping(value = "/eliminarUs/{idUsuario}")
    public String deleteUs(@PathVariable("idUsuario") Integer idUsuario) {

        Usuario usuario = usuarioService.findOne(idUsuario);

        usuario.setEstado_usuario(0);

        usuarioService.save(usuario);

        return "redirect:/listaUs";

    }
}
