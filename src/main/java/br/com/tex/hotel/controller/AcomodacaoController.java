package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.AcomodacaoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acomodacao")
public class AcomodacaoController {
    @Autowired
    private AcomodacaoDAO acomodacaoDAO;
    @GetMapping("/lista")
    public String acomodacoes(Model model){
        try{
            model.addAttribute("list", acomodacaoDAO.listAllAcomodacao());
        }catch(Exception e){
            e.printStackTrace();
        }

        return "listAcomodacao";
    }
}
