package com.example.Alexant.Controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IUsuarioRolService;
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/Alexant/")
public class login {

	@Autowired
	IUsuarioRolService usrRolesService;
	
	
	@Autowired
	IUsuarioService usuarioService;


	 @GetMapping("/login")
    public String vista(Model model,HttpServletRequest request) {

		if (request.getSession().getAttribute("usuario") == null) {
			 	
		    return "Login";  
		}
		 
        return "index2";
        
    }

 
    @RequestMapping(value = "VerificarUS", method = RequestMethod.POST)
    public String verificarUsuario(@RequestParam("usuario") String usuario, @RequestParam("Contrasena") String contrasena, Model model) {
        if (usuarioService.verificarUsuario(usuario, contrasena)) {
            model.addAttribute("mensaje", "Inicio de sesión exitoso.");
            return "redirect:/Alexant/Inicio";  
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos.");
            return "redirect:/Alexant/login"; 
        }
    }

      @GetMapping(value = "/Inicio")
    public String listarUsuarioRol(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        return "index2";/* Falta el formulario */
    }
	 

}
