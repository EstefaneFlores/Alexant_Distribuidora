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
 
import com.example.Alexant.Models.entitys.TipoBiene; 
import com.example.Alexant.Models.service.service.ITipoBieneService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class TipoBieneController {

    @Autowired
    private ITipoBieneService tipoBieneService; 

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarTipoBiene")
    public String guardarTipoBiene(@Validated TipoBiene tipoBiene) {
        tipoBiene.setEstado_tipo_biene("A");
        tipoBieneService.save(tipoBiene);
        return "redirect:/ListasTipoBiene"; /* No teneos listasVentas */
    }

    /* =============== ELIMINAR ===================== */

    @RequestMapping(value = "/eliminarTipoBiene/{id_tipo_biene}")
    public String eliminarTipoBiene(@PathVariable("id_tipo_biene") Integer id_tipo_biene) {

        TipoBiene tipoBiene = tipoBieneService.findOne(id_tipo_biene);
        tipoBiene.setEstado_tipo_biene("X");
        tipoBieneService.save(tipoBiene);
        return "redirect:/ListasTipoBiene";

    }

    /* =============== LISTAR ===================== */

    @GetMapping(value = "/ListasTipoBiene")
    public String getMethodName(Model model) {

        model.addAttribute("tipoBiene", new TipoBiene());
        model.addAttribute("tipoBienes", tipoBieneService.findAll());
 

        return "FormTipoBiene";
    }



    /* =============== MODIFICAR ===================== */

    /* Modificación Modal */
    @RequestMapping(value = "/biene/{id_tipo_biene}")
    public String getContentTipoBiene(@PathVariable(value = "id_tipo_biene") Integer id_tipo_biene, Model model,
            HttpServletRequest request) {

        model.addAttribute("tipoBiene", tipoBieneService.findOne(id_tipo_biene));

      
        return "conten :: contentTipoBiene";

    }

    /* Registrar model */
    @RequestMapping(value = "/registrarTipoBiene")
    public String getRegistroTipoBiene(Model model) {

        model.addAttribute("tipoBiene", new TipoBiene());
        model.addAttribute("tipoBienes", tipoBieneService.findAll());
 
        return "conten :: contentTipoBiene"; 
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosTipoBiene")
    public String guardarCambiosTipoBiene(@ModelAttribute TipoBiene tipoBiene) {
        tipoBiene.setEstado_tipo_biene("A");
        tipoBieneService.save(tipoBiene);
        return "redirect:/ListasTipoBiene";
    }

    // -------------------------------------------------
}
