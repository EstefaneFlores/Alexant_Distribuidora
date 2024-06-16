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

import Models.entitys.Cliente;
import Models.service.service.IClienteService;
import jakarta.servlet.http.HttpServletRequest;



@Controller
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroCliente")
    public String registroCliente(@Validated Cliente cliente, Model model) {

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());

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

    @GetMapping(value = "/Listascliente")
    public String listarcliente(Model model) {

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());

        return "listas/listaCategoria";
    }

  
    // -------------------Para las modificaciones-------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/cliente/{idCliente}")
    public String getContentCliente(@PathVariable(value = "idCliente") Integer idCliente, Model model,
            HttpServletRequest request) {

        model.addAttribute("cliente", iClienteService.findOne(idCliente));

        return "contentCliente :: contentcliente";

    }

    /* Registrar Cargo model */
    @RequestMapping(value = "/registrarCliente")
    public String getRegistroCategoria(Model model) {

        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", iClienteService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentCliente :: contentcliente";
    }

    // --------------------------------------------

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosCliente")
    public String guardarCambiosCliente(@ModelAttribute Cliente cliente) {
        cliente.setEstado_cliente("A");
        iClienteService.save(cliente);
        return "redirect:/ListasCategoria";
    }

    // -------------------------------------------------
}