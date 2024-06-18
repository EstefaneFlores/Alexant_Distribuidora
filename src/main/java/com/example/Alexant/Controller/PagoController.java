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
import com.example.Alexant.Models.entitys.Pago;
import com.example.Alexant.Models.service.service.IMonedaService;
import com.example.Alexant.Models.service.service.IPagoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    @Autowired
    private IMonedaService iMonedaService;

    // ========= Formulario para registrar =========

    @GetMapping(value = "/formRegistroPago")
    public String registroPago(@Validated Pago pago, Model model) {
        model.addAttribute("pago", new Pago());
        model.addAttribute("pagos", pagoService.findAll());

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", iMonedaService.findAll());
        return "alexant/formPago"; /*No tenemos formularios todavía
     */
    }

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarPago")
    public String guardarPago(@Validated Pago pago) {
        pago.setEstado_pago(1);
        pagoService.save(pago);
        return "redirect:/ListasPago"; /*No teneos listasVentas*/
    }

    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarPago/{id_pago}")
    public String eliminarPago(@PathVariable("id_pago") Integer id_pago) {
        Pago pago = pagoService.findOne(id_pago);
        pago.setEstado_pago(0);
        pagoService.save(pago);
        return "redirect:/ListasPago"; /*Falta el formulario*/ 

    }

    /*=============== LISTAR =====================*/

    @GetMapping(value = "/ListasPago")
    public String listarPago(Model model) {
        model.addAttribute("pago", new Pago());
        model.addAttribute("pagos", pagoService.findAll());

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", iMonedaService.findAll());

        return "listas/listaPago";/*Falta el formulario*/ 
    }

  
    /*=============== MODIFICAR =====================*/

    /* Modificación Modal */
    @RequestMapping(value = "/pago/{id_pago}")
    public String getContentPago(@PathVariable(value = "id_pago") Integer id_pago, Model model,
        HttpServletRequest request) {
        model.addAttribute("pago", pagoService.findOne(id_pago));

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", iMonedaService.findAll());

        return "contentPago :: contentPago";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarPago")
    public String getRegistroPago(Model model) {
        model.addAttribute("pago", new Pago());
        model.addAttribute("pagos", pagoService.findAll());

        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", iMonedaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentPago :: contentPago"; /*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosPago")
    public String guardarCambiosPago(@ModelAttribute Pago pago) {
        pago.setEstado_pago(1);
        pagoService.save(pago);
        return "redirect:/ListasPago";/*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // -------------------------------------------------
}
