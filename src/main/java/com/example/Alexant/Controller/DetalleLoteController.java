package com.example.Alexant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Alexant.Models.entitys.Detalle_lote;
import com.example.Alexant.Models.entitys.Empleado;
import com.example.Alexant.Models.entitys.Lote;
import com.example.Alexant.Models.entitys.Ruta;
import com.example.Alexant.Models.service.service.IDetalleLoteServicee;
import com.example.Alexant.Models.service.service.IEmpleadoService;
import com.example.Alexant.Models.service.service.ILoteService;
import com.example.Alexant.Models.service.service.IRutaService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DetalleLoteController {
    
    @Autowired
    private IDetalleLoteServicee detalleLoteService;

    @Autowired
    private ILoteService loteService;

    @Autowired
    private IEmpleadoService empleadoService;
    
    @Autowired
    private IRutaService rutaService;

    // ========= Formulario para registrar =========

    @GetMapping(value = "/formRegistroDetalleLote")
    public String registroVenta(@Validated Detalle_lote detalle_lote, Model model) {

        model.addAttribute("detalleLote", new Detalle_lote());
        model.addAttribute("detalleLotes", detalleLoteService.findAll());

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", rutaService.findAll());

        return "alexant/formUsuarioRol"; /*No tenemos formularios todavía
     */
    }
    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarDetalleLote")
    public String guardarDetalleLote(@Validated Detalle_lote detalle_lote) {
        detalle_lote.setEstado_det_lote(1);
        detalleLoteService.save(detalle_lote);
        return "redirect:/ListasDetalleLote"; /*No teneos listasVentas*/
    }
    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarDetalleLote/{id_detalle_lote}")
    public String eliminarDetalle_lote(@PathVariable("id_detalle_lote") Integer id_detalle_lote) {

        Detalle_lote detalle_lote = detalleLoteService.findOne(id_detalle_lote);
        detalle_lote.setEstado_det_lote(0);
        detalleLoteService.save(detalle_lote);
        return "redirect:/ListasDetalle_lote"; /*Falta el formulario*/ 

    }

    /*=============== LISTAR =====================*/

    @GetMapping(value = "/ListasDetalle_lote")
    public String listarDetalle_lote(Model model) {

        model.addAttribute("detalle_lote", new Detalle_lote());
        model.addAttribute("detalle_lotes", detalleLoteService.findAll());

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", rutaService.findAll());

        return "listas/listaDetalle_lote";/*Falta el formulario*/ 
    }

  
    /*=============== MODIFICAR =====================*/

    /* Modificación Modal */
    @RequestMapping(value = "/detalle_lote/{id_detalle_lote}")
    public String getContentDetalle_lote(@PathVariable(value = "id_detalle_lote") Integer id_detalle_lote, Model model,
        HttpServletRequest request) {

        model.addAttribute("detalle_lote", detalleLoteService.findOne(id_detalle_lote));


        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", rutaService.findAll());

        return "contentDetalle_lote :: contentDetalle_lote";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarDetalle_lote")
    public String getRegistroDetalle_lote(Model model) {

        model.addAttribute("detalle_lote", new Detalle_lote());
        model.addAttribute("detalle_lotes", detalleLoteService.findAll());

        model.addAttribute("lote", new Lote());
        model.addAttribute("lotes", loteService.findAll());

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", rutaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentDetalle_lote :: contentDetalle_lote"; /*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDetalle_lote")
    public String guardarCambiosDetalle_lote(@ModelAttribute Detalle_lote detalle_lote) {
        detalle_lote.setEstado_det_lote(1);
        detalleLoteService.save(detalle_lote);
        return "redirect:/ListasDetalle_lote";/*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // -------------------------------------------------
}
