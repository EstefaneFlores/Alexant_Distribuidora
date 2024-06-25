package com.example.Alexant.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.Alexant.Models.entitys.Lote;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IDetalleLoteServicee;
import com.example.Alexant.Models.service.service.ILoteService;
import com.example.Alexant.Models.service.service.IProveedorService;
import com.example.Alexant.Models.service.service.IRecepcion_ProductoService;
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class LoteController {

    @Autowired
    private ILoteService loteService;

    @Autowired
    private IDetalleLoteServicee detalleLoteServicee;

    @Autowired
    private IRecepcion_ProductoService iRecepcion_ProductoService;
    
    @Autowired
    private IProveedorService iProveedorService;
    
    @Autowired
    private IUsuarioService usuarioService;
   
    
    /*Listar lote */

    @RequestMapping(value = "/listar-lote")
    public String listar(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("userLog") != null) {
            model.addAttribute("lotes", loteService.findAll());
            model.addAttribute("detalleLotes", detalleLoteServicee.findAll());
            model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());
            model.addAttribute("proveedores", iProveedorService.findAll());

            Usuario user = (Usuario) request.getSession().getAttribute("userLog");
            Usuario userLog = usuarioService.findOne(user.getId_usuario());
            model.addAttribute("userLog", userLog);
            return "listaLote";
        } else {
            return "redirect: /Alexant/aux";
        }
    }
    

    @RequestMapping(value = "/ver-lote2/{id_lote}")
	public String verLote(@PathVariable(value = "id_lote") Integer id_lote, Model model) {
		model.addAttribute("lote", loteService.findOne(id_lote));
		model.addAttribute("modal", "true");
        
        model.addAttribute("detalleLotes", detalleLoteServicee.findAll());
        model.addAttribute("recepcion_productos", iRecepcion_ProductoService.findAll());
        model.addAttribute("proveedores", iProveedorService.findAll());
		return "Usuarios/formularioLote";
	}

    @RequestMapping(value = "/form-nuevo-lote")
	public String nuevoLote(Model model) {
		model.addAttribute("lote", new Lote());
		return "Usuarios/formularioLote";
	}


    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroLote")
    public String registroLote(@Validated Lote lote, Model model) {

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        return "FormLote";
    }

  

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarLote/{id_lote}")
    public String eliminarLote(@PathVariable("id_lote") Integer id_lote) {

        Lote lote = loteService.findOne(id_lote);
        lote.setEstado_lote("X");
        loteService.save(lote);
        return "redirect:/formRegistroLote";

    }

    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/lote/{id_lote}")
    public String getContentLote(@PathVariable(value = "id_lote") Integer id_lote, Model model,
            HttpServletRequest request) {

        model.addAttribute("lote", loteService.findOne(id_lote));

        return "Conten :: contentLote";

    }

    /*------------REGISTRAR PERSONA--------------*/
    
    @RequestMapping(value = "/registrarLote")
    public String getRegistroLote(Model model) {

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "Conten :: contentLote";
    }

      /* ------------- GUARDAR ------------ */

      @PostMapping(value = "/guardarLote")
      public String RegistrarLote(@Validated Lote lote) {
  
          lote.setEstado_lote("A");
          loteService.save(lote);
  
          return "redirect:/formRegistroLote";
  
      }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosLote")
    public String guardarCambiosLote(@ModelAttribute Lote lote) {
        lote.setEstado_lote("A");
        loteService.save(lote);
        return "redirect:/formRegistroLote";
    }

}
