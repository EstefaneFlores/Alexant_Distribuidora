package com.example.Alexant.Controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
import com.example.Alexant.Models.entitys.Usuario; 
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sistema/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;  

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena,
            HttpServletRequest request, RedirectAttributes flash) {
        Usuario usuarioObj = usuarioService.findByUsuarioAndContrasena(usuario, contrasena);

        if (usuarioObj != null) {
            // Usuario encontrado, establecer la sesión
            HttpSession session = request.getSession();
            session.setAttribute("userLog", usuarioObj);
            flash.addFlashAttribute("success", "Inicio de sesión exitoso!");
            return "redirect:/home"; // Redirigir a la página de inicio u otra página
        } else {
            // Usuario no encontrado, mostrar mensaje de error
            flash.addFlashAttribute("error", "Nombre de usuario o contraseña incorrectos!");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, RedirectAttributes flash) {
        HttpSession session = request.getSession();
        session.invalidate(); // Invalidar la sesión
        flash.addFlashAttribute("success", "Has cerrado sesión exitosamente!");
        return "redirect:/login";

    }

    @GetMapping(value = "/formUs")
    public String vistaUs(Model model, @Validated Usuario usuarios) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());
   

        return "usuarios";
    }

 

    // -------------------------GUARDAR---------------------------------------

    @PostMapping(value = "/saveUs")
    public String saveUsiario(@Validated Usuario usuarios) {

        usuarios.setEstado_usuario("A");

        usuarioService.save(usuarios);

        return "redirect:/sistema/usuario/listaUs";

    }

    // -------------------------LISTAR---------------------------------------

    @GetMapping(value = "/listaUs")
    public String listaUs(Model model, @Validated Usuario usuarios) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());
  

        return "FormUs";
    }

    // -------------------------ELIMINAR---------------------------------------

    @RequestMapping(value = "/eliminarUs/{idUsuario}")
    public String deleteUs(@PathVariable("idUsuario") Integer idUsuario) {

        Usuario usuario = usuarioService.findOne(idUsuario);

        usuario.setEstado_usuario("X");

        usuarioService.save(usuario);

        return "redirect:/sistema/usuario/listaUs";

    }
    
        /* Registrar model */
    @RequestMapping(value = "/registrarUs")
    public String getRegistroUs(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());
 
        return "conten :: contentUs";
    }

    // -------------------------EDITAR---------------------------------------

    @RequestMapping(value = "/editarUs/{idUsuario}")
    public String editarUs(Model model, @PathVariable("idUsuario") Integer idUsuario) {

        Usuario usuario = usuarioService.findOne(idUsuario);

        usuario.setEstado_usuario("A");

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());
 

        return "conten :: contentUs";
    }

}
