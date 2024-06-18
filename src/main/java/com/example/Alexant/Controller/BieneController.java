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

import com.example.Alexant.Models.entitys.Biene;
import com.example.Alexant.Models.service.service.IBieneService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BieneController {

    @Autowired
    private IBieneService bieneService;

    // ========= Formulario para registrar =========

    @GetMapping(value = "/formRegistroBiene")
    public String registroVenta(@Validated Biene biene, Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", bieneService.findAll());

        return "alexant/formBiene"; /*No tenemos formularios todavía
     */
    }

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarBiene")
    public String guardarBiene(@Validated Biene biene) {
        biene.setEstado_biene(1);
        bieneService.save(biene);
        return "redirect:/ListasBiene"; /*No teneos listasVentas*/
    }

    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarBiene/{id_biene}")
    public String eliminarBiene(@PathVariable("id_biene") Integer id_biene) {

        Biene biene = bieneService.findOne(id_biene);
        biene.setEstado_biene(0);
        bieneService.save(biene);
        return "redirect:/ListasBiene"; /*Falta el formulario*/ 

    }

    /*=============== LISTAR =====================*/

    @GetMapping(value = "/ListasBienes")
    public String listarBienes(Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", bieneService.findAll());

        return "listas/listaBiene";/*Falta el formulario*/ 
    }

  
    /*=============== MODIFICAR =====================*/

    /* Modificación Modal */
    @RequestMapping(value = "/biene/{id_biene}")
    public String getContentBiene(@PathVariable(value = "id_biene") Integer id_biene, Model model,
        HttpServletRequest request) {

        model.addAttribute("venta", bieneService.findOne(id_biene));

        return "contentDip :: contentBiene";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarBiene")
    public String getRegistroBiene(Model model) {

        model.addAttribute("biene", new Biene());
        model.addAttribute("bienes", bieneService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentDip :: contentBiene"; /*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosBiene")
    public String guardarCambiosBiene(@ModelAttribute Biene biene) {
        biene.setEstado_biene(1);
        bieneService.save(biene);
        return "redirect:/ListasBiene";/*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // -------------------------------------------------
}
