package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.ContatoDAO;
import br.com.tex.hotel.dao.EnderecoDAO;
import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.dto.HotelInputDTO;
import br.com.tex.hotel.model.dto.HotelOutputDetalheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Willian
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelDAO hotelDAO;
    @Autowired
    private EnderecoDAO enderecoDAO;
    @Autowired
    private ContatoDAO contatoDAO;

    @GetMapping("/lista")
    public String listHoteis(Model model){
        model.addAttribute("list", hotelDAO.listAllHotel());
        return "listHoteis";
    }

    @GetMapping("/formulario")
    public String formulario(Model model){
        model.addAttribute("tipoLogradouros", TipoLogradouro.values());
        model.addAttribute("estados", Estado.values());

        return "formularioHotel";
    }

    @PostMapping("/cadastra")
    public String cadstra(HotelInputDTO hotelInputDTO, RedirectAttributes redirectAttributes){

        hotelDAO.inserir(hotelInputDTO.toHotel(hotelInputDTO));
        redirectAttributes.addFlashAttribute("sucess", "Hotel cadastrado com sucesso!");
        return "redirect:/hotel/lista";
    }

    @GetMapping("/detalhe")
    public String mostrarDetalhe(@RequestParam("id") Integer id, Model model){
        model.addAttribute("hotel", new HotelOutputDetalheDTO(hotelDAO.getById(id)));
        return "detalheHotel";
    }

    @Transactional
    @GetMapping("/deleta/{id}")
    public String deleta(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        hotelDAO.delete(hotelDAO.getById(id));
        redirectAttributes.addFlashAttribute("sucess", "Hotel Excluído com sucesso!");
        return "redirect:/hotel/lista";
    }
}
