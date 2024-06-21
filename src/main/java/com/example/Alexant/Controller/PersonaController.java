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

import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IPersonaService;
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PersonaController {
    
    @Autowired
    private IPersonaService iPersonaService;
    @Autowired
    private IUsuarioService usuarioService;


    /*Listar persona */

    @RequestMapping(value = "/listar-persona")
    public String listar(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("userLog") != null) {
            model.addAttribute("personas", iPersonaService.findAll());
            
            // Persona pers = (Persona) request.getSession().getAttribute("userLog");

            Usuario user = (Usuario) request.getSession().getAttribute("userLog");
            Usuario userLog = usuarioService.findOne(user.getId_usuario());
            model.addAttribute("userLog", userLog);
            return "listaPersona";
        } else {
            return "redirect: /Alexant/aux";
        }
    }

    @RequestMapping(value = "/ver-persona2/{id_persona}")
	public String verPersona(@PathVariable(value = "id_persona") Integer id_persona, Model model) {
		model.addAttribute("persona", iPersonaService.findOne(id_persona));
		model.addAttribute("modal", "true");
		return "Usuarios/formularioPersona";
	}

    @RequestMapping(value = "/form-nueva-persona")
	public String nuevaPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "Usuarios/formularioPersona";
	}


    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroPersona")
    public String registroCliente(@Validated Persona persona, Model model) {

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "FormPersona";
    }

  

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarPersona/{id_persona}")
    public String eliminarPersona(@PathVariable("id_persona") Integer id_persona) {

        Persona persona = iPersonaService.findOne(id_persona);
        persona.setEstado_per("X");
        iPersonaService.save(persona);
        return "redirect:/formRegistroPersona";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    // @GetMapping(value = "/Listaspersonas")
    // public String listarpersona(Model model) {

    //     model.addAttribute("persona", new Persona());
    //     model.addAttribute("personas", iPersonaService.findAll());

    //     return "listas/listaPersona";
    // }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/persona/{idPersona}")
    public String getContentPersona(@PathVariable(value = "idPersona") Integer idPersona, Model model,
            HttpServletRequest request) {

        model.addAttribute("persona", iPersonaService.findOne(idPersona));

        return "Conten :: contentPersona";

    }

    /*------------REGISTRAR PERSONA--------------*/
    
    @RequestMapping(value = "/registrarPersona")
    public String getRegistroPersona(Model model) {

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "Conten :: contentPersona";
    }

      /* ------------- GUARDAR ------------ */

      @PostMapping(value = "/guardarPersona")
      public String RegistrarPersona(@Validated Persona persona) {
  
          persona.setEstado_per("A");
          iPersonaService.save(persona);
  
          return "redirect:/formRegistroPersona";
  
      }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosPersona")
    public String guardarCambiosPersona(@ModelAttribute Persona persona) {
        persona.setEstado_per("A");
        iPersonaService.save(persona);
        return "redirect:/formRegistroPersona";
    }
    
}