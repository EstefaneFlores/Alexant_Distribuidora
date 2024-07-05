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

import com.example.Alexant.Models.entitys.Empleado;
import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.entitys.Usuario;
import com.example.Alexant.Models.service.service.IEmpleadoService;
import com.example.Alexant.Models.service.service.IPersonaService;
import com.example.Alexant.Models.service.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmpleadoController {
    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private IPersonaService IpersonaService;

    @Autowired
    private IUsuarioService iUsuarioService;

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarEmpleado")
    public String guardarEmpleado(@Validated Empleado empleado) {
        empleado.setEstado_empleado("A");
        empleadoService.save(empleado);

      return "redirect:/ListasEmpleado";
    }

    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarEmpleado/{id_empleado}")
    public String eliminarEmpleado(@PathVariable("id_empleado") Integer id_empleado) {

        Empleado empleado = empleadoService.findOne(id_empleado);
        empleado.setEstado_empleado("X");
        empleadoService.save(empleado);

        return "redirect:/ListasEmpleado";  

    }

    /*=============== LISTAR =====================*/

    @GetMapping(value = "/ListasEmpleado")
    public String listarEmpleado(Model model) {

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", IpersonaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", iUsuarioService.findAll());

        return "/FormEmpleado"; 
    }

  
    /*=============== MODIFICAR =====================*/

    /* Modificación Modal */
    @RequestMapping(value = "/empleado/{id_empleado}")
    public String getContentEmpleado(@PathVariable(value = "id_empleado") Integer id_empleado, Model model,
        HttpServletRequest request) {

        model.addAttribute("empleado", empleadoService.findOne(id_empleado));

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", IpersonaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", iUsuarioService.findAll());

        return "conten :: contentEmpleado";

    }

    /* Registrar model */
    @RequestMapping(value = "/registrarEmpleado")
    public String getRegistroEmpleado(Model model) {

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", IpersonaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", iUsuarioService.findAll());
 
        return "conten :: contentEmpleado";  
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosEmpleado")
    public String guardarCambiosEmpleado(@ModelAttribute Empleado empleado) {
        empleado.setEstado_empleado("A");
        empleadoService.save(empleado);
        return "redirect:/ListasEmpleado"; 
    }

   
}
