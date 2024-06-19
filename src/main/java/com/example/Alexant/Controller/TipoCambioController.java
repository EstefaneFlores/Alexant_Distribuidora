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

import com.example.Alexant.Models.entitys.Moneda;
import com.example.Alexant.Models.entitys.TipoCambio;
import com.example.Alexant.Models.service.service.IMonedaService;
import com.example.Alexant.Models.service.service.ITipoCambioService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TipoCambioController {

    @Autowired
    private ITipoCambioService tipoCambioService;
    @Autowired
    private IMonedaService monedaService;

    // ========= Formulario para registrar =========

    @GetMapping(value = "/formRegistroTipoCambio")
    public String registroVenta(@Validated TipoCambio tipoCambio, Model model) {

        model.addAttribute("tipoCambio", new TipoCambio());
        model.addAttribute("tipoCambios", tipoCambioService.findAll());

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", monedaService.findAll());

        return "alexant/formTipoCambio"; /*
                                          * No tenemos formularios todavía
                                          */
    }

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarTipoCambio")
    public String guardarTipoCambio(@Validated TipoCambio tipoCambio) {
        tipoCambio.setEstado_tipo_cambio(1);
        tipoCambioService.save(tipoCambio);
        return "redirect:/ListasTipoCambio"; /* No teneos listasVentas */
    }

    /* =============== ELIMINAR ===================== */

    @RequestMapping(value = "/eliminarTipoCambio/{id_tipo_cambio}")
    public String eliminarTipoBiene(@PathVariable("id_tipo_cambio") Integer id_tipo_cambio) {

        TipoCambio tipoCambio = tipoCambioService.findOne(id_tipo_cambio);
        tipoCambio.setEstado_tipo_cambio(0);
        tipoCambioService.save(tipoCambio);
        return "redirect:/ListasTipoCambio"; /* Falta el formulario */

    }

    /* =============== LISTAR ===================== */

    @GetMapping(value = "/ListasTipoCambios")
    public String listarTipoCambios(Model model) {

        model.addAttribute("tipoCambio", new TipoCambio());
        model.addAttribute("tipoCambioa", tipoCambioService.findAll());

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", monedaService.findAll());

        return "listas/listaTipoCambio";/* Falta el formulario */
    }

    /* =============== MODIFICAR ===================== */

    /* Modificación Modal */
    @RequestMapping(value = "/tipoCambio/{id_tipo_cambio}")
    public String getContentTipoCambio(@PathVariable(value = "id_tipo_cambio") Integer id_tipo_cambio, Model model,
            HttpServletRequest request) {

        model.addAttribute("tipoCambio", new TipoCambio());
        model.addAttribute("tipoCambios", tipoCambioService.findAll());

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", monedaService.findAll());

        return "contentDip :: contentTipoCambio";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarTipoCambio")
    public String getRegistroTipoCambio(Model model) {

        model.addAttribute("tipoCambio", new TipoCambio());
        model.addAttribute("tipoCambios", tipoCambioService.findAll());

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", monedaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentDip :: contentdip"; /* Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosTipoCambio")
    public String guardarCambiosTipoCambio(@ModelAttribute TipoCambio tipoCambio) {
        tipoCambio.setEstado_tipo_cambio(1);
        tipoCambioService.save(tipoCambio);
        return "redirect:/ListasTipoCambio";/* Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // -------------------------------------------------
}
