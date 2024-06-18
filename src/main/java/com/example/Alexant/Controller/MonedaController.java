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

import com.example.Alexant.Models.entitys.Moneda;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IMonedaService;

import jakarta.servlet.http.HttpServletRequest;
import com.example.Alexant.Models.entitys.Moneda;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IMonedaService;

import jakarta.servlet.http.HttpServletRequest;
import com.example.Alexant.Models.entitys.Moneda;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IMonedaService;

import jakarta.servlet.http.HttpServletRequest;
import com.example.Alexant.Models.entitys.Moneda;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IMonedaService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MonedaController {
    @Autowired
    private IMonedaService monedaService;

    // ========= Formulario para registrar =========

    @GetMapping(value = "/formRegistroMoneda")
    public String registroVenta(@Validated Moneda moneda, Model model) {

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", monedaService.findAll());

        return "alexant/formMoneda"; /*No tenemos formularios todavía
     */
    }

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarMoneda")
    public String guardarMoneda(@Validated Moneda moneda) {
        moneda.setEstado_moneda(1);
        monedaService.save(moneda);
        return "redirect:/ListasMoneda"; /*No teneos listasVentas*/
    }

    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarMoneda/{id_moneda}")
    public String eliminarMoneda(@PathVariable("id_moneda") Integer id_moneda) {

        Moneda moneda = monedaService.findOne(id_moneda);
        moneda.setEstado_moneda(0);
        monedaService.save(moneda);
        return "redirect:/ListasMoneda"; /*Falta el formulario*/ 

    }

    /*=============== LISTAR =====================*/

    @GetMapping(value = "/ListasMoneda")
    public String listarMoneda(Model model) {

        model.addAttribute("moneda", new Venta());
        model.addAttribute("monedas", monedaService.findAll());

        return "listas/listaMoneda";/*Falta el formulario*/ 
    }

  
    /*=============== MODIFICAR =====================*/

    /* Modificación Modal */
    @RequestMapping(value = "/moneda/{id_moneda}")
    public String getContentMoneda(@PathVariable(value = "id_moneda") Integer id_moneda, Model model,
        HttpServletRequest request) {

        model.addAttribute("moneda", monedaService.findOne(id_moneda));

        return "contentMoneda :: contentMoneda";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarMoneda")
    public String getRegistroMoneda(Model model) {

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", monedaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentMoneda :: contentMoneda"; /*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosMoneda")
    public String guardarCambiosMoneda(@ModelAttribute Moneda moneda) {
        moneda.setEstado_moneda(1);
        monedaService.save(moneda);
        return "redirect:/ListasMoneda";/*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // -------------------------------------------------
}
