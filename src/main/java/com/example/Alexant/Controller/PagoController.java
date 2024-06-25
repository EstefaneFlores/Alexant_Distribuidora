package com.example.Alexant.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.Alexant.Models.entitys.Moneda;
import com.example.Alexant.Models.entitys.Pago;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.entitys.Venta;
import com.example.Alexant.Models.service.service.IMonedaService;
import com.example.Alexant.Models.service.service.IPagoService;
import com.example.Alexant.Models.service.service.ITipoCambioService;
import com.example.Alexant.Models.service.service.IUsuarioService;
import com.example.Alexant.Models.service.service.IVentaService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class PagoController {
    @Autowired
    private IPagoService pagoService;

    @Autowired
    private IVentaService ventaService;;

    @Autowired
    private IMonedaService monedaService;
    
    @Autowired
    private IUsuarioService usuarioService;
   

    @GetMapping("/listarPago")
    public String listarPago(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("userLog") != null) {
            model.addAttribute("pagos", pagoService.findAll());
            model.addAttribute("ventas", ventaService.findAll());
            model.addAttribute("monedas", monedaService.findAll());

            Usuario user = (Usuario) request.getSession().getAttribute("userLog");
            Usuario userLog = usuarioService.findOne(user.getId_usuario());
            model.addAttribute("userLog", userLog);
            return "listaPago";
        } else {
            return "redirect:/aux";
        }
    }

    @RequestMapping(value = "/ver-pago/{id_pago}")
    public String verPago(@PathVariable(value = "id_pago") Integer id_pago, Model model) {
        model.addAttribute("pago", pagoService.findOne(id_pago));
        model.addAttribute("ventas", ventaService.findAll());
        model.addAttribute("monedas", monedaService.findAll());

        return "Usuarios/formularioPago";
    }

    @RequestMapping(value = "/form-nuevo-pago")
    public String nuevaPago(Model model) {
        model.addAttribute("pago", new Pago());
        model.addAttribute("ventas", ventaService.findAll());
        model.addAttribute("monedas", monedaService.findAll());

        return "Usuarios/formularioPago";
    }

    @GetMapping(value = "/formRegistroPago")
    public String registroPago(Model model) {
        model.addAttribute("pago", new Pago());
        model.addAttribute("pagos", pagoService.findAll());
        model.addAttribute("ventas", ventaService.findAll());
        model.addAttribute("monedas", monedaService.findAll());
    
        return "FormPago";
    }
    

    @RequestMapping(value = "/eliminarPago/{id_pago}")
    public String eliminarPago(@PathVariable("id_pago") Integer id_pago) {
        Pago pago = pagoService.findOne(id_pago);
        pago.setEstado_pago("X");
        pagoService.save(pago);

        return "redirect:/formRegistroPago";
    }

    @RequestMapping(value = "/pago/{id_pago}")
    public String getContentPago(@PathVariable(value = "id_pago") Integer id_pago, Model model) {
        model.addAttribute("pago", pagoService.findOne(id_pago));
        model.addAttribute("ventas", ventaService.findAll());
        model.addAttribute("monedas", monedaService.findAll());      

        return "Conten :: contentPago";
    }

    @RequestMapping(value = "/registrarPago")
    public String getRegistroPago(Model model) {
        model.addAttribute("pago", new Pago());
        model.addAttribute("pagos", pagoService.findAll());
        model.addAttribute("ventas", ventaService.findAll());
        model.addAttribute("monedas", monedaService.findAll());     

        return "Conten :: contentPago";
    }

    @PostMapping(value = "/guardarPago")
    public String registrarPago(@Validated Pago pago) {
        pago.setEstado_pago("A");
        pagoService.save(pago);
        return "redirect:/formRegistroPago";
    }

    @PostMapping(value = "/guardarCambiosPago")
    public String guardarCambiosPago(@ModelAttribute Pago pago) {
        pago.setEstado_pago("A");
        pagoService.save(pago);
        return "redirect:/formRegistroPago";
    }
}
