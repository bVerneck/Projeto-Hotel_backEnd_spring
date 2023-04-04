package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.ContatoDAO;
import br.com.tex.hotel.dao.EnderecoDAO;
import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.Contato;
import br.com.tex.hotel.model.Endereco;
import br.com.tex.hotel.model.Hotel;
import br.com.tex.hotel.model.dto.HotelInputDTO;
import br.com.tex.hotel.model.dto.HotelOutputDetalheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String cadstra(HotelInputDTO hotelInputDTO){

        hotelDAO.inserir(hotelInputDTO.toHotel(hotelInputDTO));
        return "redirect:/hotel/lista";
    }

    @GetMapping("/detalhe")
    public String mostrarDetalhe(@RequestParam("id") Integer id, Model model){
        model.addAttribute("hotel", new HotelOutputDetalheDTO(hotelDAO.getById(id)));
        return "detalheHotel";
    }
}
