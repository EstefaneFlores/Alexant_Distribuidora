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

import com.example.Alexant.Models.entitys.Detalle_lote;
import com.example.Alexant.Models.entitys.Empleado;
import com.example.Alexant.Models.entitys.Lote;
import com.example.Alexant.Models.service.service.IDetalleLoteServicee;
import com.example.Alexant.Models.service.service.IEmpleadoService;
import com.example.Alexant.Models.service.service.ILoteService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DetalleLoteController {
    
    @Autowired
    private IDetalleLoteServicee detalleLoteService;

    @Autowired
    private ILoteService loteService;

    @Autowired
    private IEmpleadoService empleadoService;
    

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarDetalleLote")
    public String guardarDetalleLote(@Validated Detalle_lote detalle_lote) {
        detalle_lote.setEstado_det_lote("A");
        detalleLoteService.save(detalle_lote);
        return "redirect:/ListasDetalle_lote"; 
    }
    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarDetalleLote/{id_detalle_lote}")
    public String eliminarDetalle_lote(@PathVariable("id_detalle_lote") Integer id_detalle_lote) {

        Detalle_lote detalle_lote = detalleLoteService.findOne(id_detalle_lote);
        detalle_lote.setEstado_det_lote("X");
        detalleLoteService.save(detalle_lote);
        return "redirect:/ListasDetalle_lote"; 
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

        return "formDetLote";
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


        return "conten :: contentDetalle_lote";

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

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "conten :: contentDetalle_lote"; 
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDetalle_lote")
    public String guardarCambiosDetalle_lote(@ModelAttribute Detalle_lote detalle_lote) {
        detalle_lote.setEstado_det_lote("A");
        detalleLoteService.save(detalle_lote);
        return "redirect:/ListasDetalle_lote";
    }

    // -------------------------------------------------
}
