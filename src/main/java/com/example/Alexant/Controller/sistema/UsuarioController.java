package com.example.Alexant.Controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Alexant.Models.entitys.Empleado;
import com.example.Alexant.Models.entitys.Ruta;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IEmpleadoService;
import com.example.Alexant.Models.service.service.IRutaService;
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/sistema/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IEmpleadoService empleadoService;
    @Autowired
    private IRutaService iRutaService;

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

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

        return "usuarios";
    }
    @GetMapping(value = "/")
    public String init() {
        return "redirect:/Alexant/";
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

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

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

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

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
