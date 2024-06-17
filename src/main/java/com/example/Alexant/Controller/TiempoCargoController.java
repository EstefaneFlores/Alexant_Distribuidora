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
import org.springframework.web.bind.annotation.RestController;

import com.example.Alexant.Models.service.service.ITiempoCargoService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TiempoCargoController {
    @Autowired
    private ITiempoCargoService tiempoCargoService;

    // // ========= Formulario para registrar =========

    // @GetMapping(value = "/formRegistroTiempoCargo")
    // public String registroTiempoCargo(@Validated TiempoCargo tiempoCargo, Model model) {

    //     model.addAttribute("tiempoCargo", new TiempoCargo());
    //     model.addAttribute("tiempoCargos", ITiempoCargoService.findAll());

    //     return "alexant/formTiempoCargo"; /*No tenemos formularios todavía
    //  */
    // }

    // /* ================= GUARDAR =================== */

    // @PostMapping(value = "/guardarTiempoCargo")
    // public String guardarTiempoCargo(@Validated TiempoCargo tiempoCargo) {
    //     tiempoCargo.setEstado_tcargo(1);
    //     tiempo_en_cargoService.save(venta);
    //     return "redirect:/ListasVenta"; /*No teneos listasVentas*/
    // }

    // /*=============== ELIMINAR =====================*/

    // @RequestMapping(value = "/eliminarVenta/{id_venta}")
    // public String eliminarVenta(@PathVariable("id_venta") Integer id_venta) {

    //     Venta venta = iVentaService.findOne(id_venta);
    //     venta.setEstado_venta(0);
    //     iVentaService.save(venta);
    //     return "redirect:/ListasVenta"; /*Falta el formulario*/ 

    // }

    // /*=============== LISTAR =====================*/

    // @GetMapping(value = "/ListasVentas")
    // public String listarVentas(Model model) {

    //     model.addAttribute("venta", new Venta());
    //     model.addAttribute("ventas", iVentaService.findAll());

    //     return "listas/listaVenta";/*Falta el formulario*/ 
    // }

  
    // /*=============== MODIFICAR =====================*/

    // /* Modificación Modal */
    // @RequestMapping(value = "/venta/{id_venta}")
    // public String getContentVenta(@PathVariable(value = "id_venta") Integer id_venta, Model model,
    //     HttpServletRequest request) {

    //     model.addAttribute("venta", iVentaService.findOne(id_venta));

    //     return "contentDip :: contentVenta";

    // }

    // /* Registrar DIP model */
    // @RequestMapping(value = "/registrarVenta")
    // public String getRegistroVenta(Model model) {

    //     model.addAttribute("venta", new Venta());
    //     model.addAttribute("ventas", iVentaService.findAll());

    //     // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
    //     return "contentDip :: contentdip"; /*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    // }

    // // --------------------------------------------

    // /* Guardar Cambios */
    // @PostMapping(value = "/guardarCambiosDip")
    // public String guardarCambiosDip(@ModelAttribute Venta venta) {
    //     venta.setEstado_venta(1);
    //     iVentaService.save(venta);
    //     return "redirect:/ListasVenta";/*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    // }

    // // -------------------------------------------------
}
