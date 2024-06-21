package com.example.Alexant.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.Alexant.Models.entitys.Moneda;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IMonedaService;
import com.example.Alexant.Models.service.service.ITipoCambioService;
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class MonedaController {

    @Autowired
    private IMonedaService monedaService;
    @Autowired
    private ITipoCambioService tipoCambioService;
    
    @Autowired
    private IUsuarioService usuarioService;
   

    @GetMapping("/listarMoneda")
    public String listarMoneda(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("userLog") != null) {
            model.addAttribute("monedas", monedaService.findAll());
            model.addAttribute("tiposCambios", tipoCambioService.findAll());

            Usuario user = (Usuario) request.getSession().getAttribute("userLog");
            Usuario userLog = usuarioService.findOne(user.getId_usuario());
            model.addAttribute("userLog", userLog);
            return "listaMoneda";
        } else {
            return "redirect:/aux";
        }
    }

    @RequestMapping(value = "/ver-moneda/{id_moneda}")
    public String verMoneda(@PathVariable(value = "id_moneda") Integer id_moneda, Model model) {
        model.addAttribute("moneda", monedaService.findOne(id_moneda));
        model.addAttribute("tiposCambios", tipoCambioService.findAll());

        return "Usuarios/formularioMoneda";
    }

    @RequestMapping(value = "/form-nueva-moneda")
    public String nuevaMoneda(Model model) {
        model.addAttribute("moneda", new Moneda());
        model.addAttribute("tiposCambios", tipoCambioService.findAll());
        return "Usuarios/formularioMoneda";
    }

    @GetMapping(value = "/formRegistroMoneda")
    public String registroMoneda(Model model) {
        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", monedaService.findAll());
        model.addAttribute("tiposCambios", tipoCambioService.findAll());

        return "FormMoneda";
    }

    @RequestMapping(value = "/eliminarMoneda/{id_moneda}")
    public String eliminarMoneda(@PathVariable("id_moneda") Integer id_moneda) {
        Moneda moneda = monedaService.findOne(id_moneda);
        moneda.setEstado_moneda("X");
        monedaService.save(moneda);
        return "redirect:/formRegistroMoneda";
    }

    @RequestMapping(value = "/moneda/{id_moneda}")
    public String getContentMoneda(@PathVariable(value = "id_moneda") Integer id_moneda, Model model) {
        model.addAttribute("moneda", monedaService.findOne(id_moneda));
        model.addAttribute("tiposCambios", tipoCambioService.findAll());
        return "Conten :: contentMoneda";
    }

    @RequestMapping(value = "/registrarMoneda")
    public String getRegistroMoneda(Model model) {
        model.addAttribute("moneda", new Moneda());
        model.addAttribute("monedas", monedaService.findAll());
        model.addAttribute("tiposCambios", tipoCambioService.findAll());
        return "Conten :: contentMoneda";
    }

    @PostMapping(value = "/guardarMoneda")
    public String registrarMoneda(@Validated Moneda moneda) {
        moneda.setEstado_moneda("A");
        monedaService.save(moneda);
        return "redirect:/formRegistroMoneda";
    }

    @PostMapping(value = "/guardarCambiosMoneda")
    public String guardarCambiosMoneda(@ModelAttribute Moneda moneda) {
        moneda.setEstado_moneda("A");
        monedaService.save(moneda);
        return "redirect:/formRegistroMoneda";
    }
}
