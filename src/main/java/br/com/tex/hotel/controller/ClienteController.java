package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteDAO clienteDAO;

    @GetMapping("/lista")
    public String clientes(Model model){
        model.addAttribute("list", clienteDAO.listAllCliente());

        return "listCliente";
    }

}
