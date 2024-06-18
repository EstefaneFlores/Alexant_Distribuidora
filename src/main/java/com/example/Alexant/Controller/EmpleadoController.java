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

import com.example.Alexant.Models.entitys.Empleado;
import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.service.service.IEmpleadoService;
import com.example.Alexant.Models.service.service.IPersonaService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class EmpleadoController {
    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private IPersonaService IpersonaService;


    // ========= Formulario para registrar =========

    @GetMapping(value = "/formRegistroEmpleado")
    public String registroVenta(@Validated Empleado empleado, Model model) {

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        
        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", IpersonaService.findAll());

        return "alexant/formEmpleado"; /*No tenemos formularios todavía
     */
    }

    /* ================= GUARDAR =================== */

    @PostMapping(value = "/guardarEmpleado")
    public String guardarEmpleado(@Validated Empleado empleado) {
        empleado.setEstado_empleado(1);
        empleadoService.save(empleado);
        return "redirect:/ListasEmpleado"; /*No teneos listasVentas*/
    }

    /*=============== ELIMINAR =====================*/

    @RequestMapping(value = "/eliminarEmpleado/{id_empleado}")
    public String eliminarEmpleado(@PathVariable("id_empleado") Integer id_empleado) {

        Empleado empleado = empleadoService.findOne(id_empleado);
        empleado.setEstado_empleado(0);
        empleadoService.save(empleado);
        return "redirect:/ListasEmpleado"; /*Falta el formulario*/ 

    }

    /*=============== LISTAR =====================*/

    @GetMapping(value = "/ListasEmpleado")
    public String listarEmpleado(Model model) {

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", IpersonaService.findAll());

        return "listas/listaEmpleado";/*Falta el formulario*/ 
    }

  
    /*=============== MODIFICAR =====================*/

    /* Modificación Modal */
    @RequestMapping(value = "/empleado/{id_empleado}")
    public String getContentEmpleado(@PathVariable(value = "id_empleado") Integer id_empleado, Model model,
        HttpServletRequest request) {

        model.addAttribute("empleado", empleadoService.findOne(id_empleado));

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", IpersonaService.findAll());

        return "contentEmpleado :: contentEmpleado";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarEmpleado")
    public String getRegistroEmpleado(Model model) {

        model.addAttribute("empleado", new Empleado());
        model.addAttribute("empleados", empleadoService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", IpersonaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentEmpleado :: contentEmpleado"; /*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosEmpleado")
    public String guardarCambiosEmpleado(@ModelAttribute Empleado empleado) {
        empleado.setEstado_empleado(1);
        empleadoService.save(empleado);
        return "redirect:/ListasEmpleado";/*Faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */
    }

    // -------------------------------------------------
}
