package com.example.Alexant.Controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.entitys.Rol;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.entitys.UsuarioRol;
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

	  @GetMapping(value = "/Inicio")
    public String listarUsuarioRol(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        return "index2";/* Falta el formulario */
    }

	// Archive archive = new Archive();

	@RequestMapping(value = "/prueba")
	public String index(Model model, HttpServletRequest request) {
		// Verifica si el usuario está logueado
		if (request.getSession().getAttribute("userLog") != null) {
			Usuario user = (Usuario) request.getSession().getAttribute("userLog");
			Usuario userLog = usuarioService.findOne(user.getId_usuario());
			Persona persona = userLog.getPersona();
			
			// Añade atributos al modelo
			model.addAttribute("userLog", userLog);
			model.addAttribute("persona", persona);
			
			// Retorna la vista principal
			return "index2";
		} else {
			// Si no hay usuario logueado, también retorna la vista principal
			return "index2";
		}
	}
	@RequestMapping(value = "/buscar")
	public String buscarP(Model model) {
		model.addAttribute("persona", new Persona());

		return "index";
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscarPersonas(@Validated Persona persona, Model model) {
		if (persona.getCi().length() > 0 || persona.getEmail().length() > 0) {
			model.addAttribute("personas", iPersonaService.getAllPersonaCiEmail(persona.getCi(), persona.getEmail()));
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
	

	@RequestMapping(value = "/persona/{id}")
    public String buscarPersonaPorId(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash) {
        Persona persona = null;

        if (id > 0) {
            persona = iPersonaService.findOne(id);
            if (persona == null) {
                flash.addFlashAttribute("error", "El ID de la persona no existe en la base de datos!");
                return "redirect:/personas/";
            }
        } else {
            flash.addFlashAttribute("error", "El ID de la persona no puede ser cero!");
            return "redirect:/personas/";
        }

        model.addAttribute("persona", persona);
        return "detallePersona";
    }
}


