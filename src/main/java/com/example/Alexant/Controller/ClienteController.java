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

import com.example.Alexant.Models.entitys.Cliente;
import com.example.Alexant.Models.entitys.Persona;
import com.example.Alexant.Models.entitys.Ruta;
import com.example.Alexant.Models.service.service.IClienteService;
import com.example.Alexant.Models.service.service.IPersonaService;
import com.example.Alexant.Models.service.service.IRutaService;



import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;
    @Autowired
    private IRutaService iRutaService;
    @Autowired
    private IPersonaService iPersonaService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroCliente")
    public String registroCliente(@Validated Cliente cliente, Model model) {

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

         model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "formularios/formModeloCliente";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarCliente")
    public String RegistrarCliente(@Validated Cliente cliente) {

        cliente.setEstado_cliente("A");
        iClienteService.save(cliente);

        return "redirect:/ListasCliente";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarCliente/{id_Cliente}")
    public String eliminarCliente(@PathVariable("id_cliente") Integer id_cliente) {

        Cliente cliente = iClienteService.findOne(id_cliente);
        cliente.setEstado_cliente("X");
        iClienteService.save(cliente);

        return "redirect:/ListasCliente";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasCliente")
    public String listarcliente(Model model) {

       model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

         model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "listas/listaCategoria";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/cliente/{idCliente}")
    public String getContentCliente(@PathVariable(value = "idCliente") Integer idCliente, Model model,
            HttpServletRequest request) {

              model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

         model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        return "contentCliente :: contentcliente";

    }

    /* Registrar Cliente model */
    @RequestMapping(value = "/registrarCliente")
    public String getRegistroCategoria(Model model) {

           model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());

        model.addAttribute("ruta", new Ruta());
        model.addAttribute("rutas", iRutaService.findAll());

         model.addAttribute("persona", new Persona());
        model.addAttribute("personas", iPersonaService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentCliente :: contentcliente";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosCliente")
    public String guardarCambiosCliente(@ModelAttribute Cliente cliente) {
        cliente.setEstado_cliente("A");
        iClienteService.save(cliente);
        return "redirect:/ListasCliente";
    }

    // -------------------------------------------------
}
