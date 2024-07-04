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

import com.example.Alexant.Models.entitys.Cargo;
import com.example.Alexant.Models.entitys.Empleado;
import com.example.Alexant.Models.entitys.TiempoCargo;
import com.example.Alexant.Models.service.service.ICargoService;
import com.example.Alexant.Models.service.service.IEmpleadoService;
import com.example.Alexant.Models.service.service.ITiempoCargoService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TiempoCargoController {

    @Autowired
    private ITiempoCargoService tiempoCargoService;
    @Autowired
    private ICargoService iCargoService;
    @Autowired
    private IEmpleadoService empleadoService;



    /* =============== ELIMINAR ===================== */

    @RequestMapping(value = "/eliminarTiempoCargo/{id_tiempo_cargo}")
    public String eliminarTiempoCargo(@PathVariable("id_tiempo_cargo") Integer id_tiempo_cargo) {

        TiempoCargo tiempoCargo = tiempoCargoService.findOne(id_tiempo_cargo);
        tiempoCargo.setEstado_tcargo("X");
        tiempoCargoService.save(tiempoCargo);
        return "redirect:/AdministrarTiempoCargo"; /* Falta el formulario */

    }

    /* =============== LISTAR ===================== */

    @GetMapping(value = "/AdministrarTiempoCargo")
    public String listarTiempoCargo(Model model) {

        model.addAttribute("tiempoCargo", new TiempoCargo());
        model.addAttribute("tiempoCargos", tiempoCargoService.findAll());

        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargo", iCargoService.findAll());

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        return "FormTiempoCargo"; 
    }

    /* =============== MODIFICAR ===================== */

    /* Modificación Modal */
    @RequestMapping(value = "/tiempoCargo/{id_tiempo_cargo}")
    public String getContentTiempoCargo(@PathVariable(value = "id_tiempo_cargo") Integer id_tiempo_cargo, Model model,
            HttpServletRequest request) {
 
        model.addAttribute("tiempoCargo", tiempoCargoService.findAll());

        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", iCargoService.findAll());

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());
        
        return "conten :: contentListasTiempoCargo";

    }

    /* Registrar model */
    @RequestMapping(value = "/registrarTiempoCargo")
    public String getRegistroTiempoCargo(Model model) {

        model.addAttribute("tiempoCargo", new TiempoCargo());
        model.addAttribute("tiempoCargos", tiempoCargoService.findAll());

        model.addAttribute("cargo", new Cargo());
        model.addAttribute("cargos", iCargoService.findAll());

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "conten :: contentListasTiempoCargo";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosTiempoCargo")
    public String guardarCambiosTipoCambio(@ModelAttribute TiempoCargo tiempoCargo) {
        tiempoCargo.setEstado_tcargo("A");
        tiempoCargoService.save(tiempoCargo);
        return "redirect:/AdministrarTiempoCargo"; 
    }

    // -------------------------------------------------
    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarTiempoCargo")
    public String guardarTiempoCargo(@Validated TiempoCargo tiempoCargo) {
        tiempoCargo.setEstado_tcargo("A");
        tiempoCargoService.save(tiempoCargo);
        return "redirect:/AdministrarTiempoCargo"; /* No teneos listasVentas */
    }

}
