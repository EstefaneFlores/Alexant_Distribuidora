package com.example.Alexant.Controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IPersonaService;
import com.example.Alexant.Models.service.service.IUsuarioService;
import com.example.Alexant.Models.service.service.IVentaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Alexant/")
@SessionAttributes("persona")
public class IndexController {
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IVentaService iVentaService;
    @Autowired
    private IPersonaService iPersonaService;

    // Archive archive = new Archive();
    @RequestMapping(value = "/buscar")
	public String buscarP(Model model) {
		model.addAttribute("persona", new Persona());

		return "descarga";
	}

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscarPersonas(@Validated Persona persona, Model model) {
		if (persona.getCi().length() > 0 || persona.getEmail().length() > 0) {
			model.addAttribute("personas", iPersonaService.getAllPersonaCiCorreo(persona.getCi(), persona.getEmail()));
		}
		model.addAttribute("persona", new Persona());

		return "descarga";
	}

    
	@RequestMapping(value = "/aux")
	public String login(Model model, HttpServletRequest request) {
		if (request.getSession().getAttribute("userLog") != null) {
			return "redirect:/CPEyFP-uap/curso/listar";
		} else {
			return "login";
		}
	}

    
	// @RequestMapping(value = "/")
	// public String index(Model model, HttpServletRequest request) {
	// 	model.addAttribute("ventas", iVentaService.());
	// 	if (request.getSession().getAttribute("userLog") != null) {
	// 		Usuario user = (Usuario) request.getSession().getAttribute("userLog");
	// 		Usuario userLog = usuarioService.findOne(user.getId_usuario());
	// 		Persona persona = userLog.getPersona();
	// 		model.addAttribute("userLog", userLog);
	// 		return "index";
	// 	} else {
	// 		return "index";
	// 	}

	// }

}
