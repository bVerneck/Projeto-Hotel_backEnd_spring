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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Contato contatoHotel = hotelInputDTO.contatoHotel(hotelInputDTO);
        Endereco enderecoHotel = hotelInputDTO.enderecoHotel(hotelInputDTO);

        contatoHotel.setId(contatoDAO.inserir(contatoHotel));
        enderecoHotel.setId(enderecoDAO.inserir(enderecoHotel));

        Hotel hotel = hotelInputDTO.toHotel(hotelInputDTO);
        hotel.setContato(contatoHotel);
        hotel.setEndereco(enderecoHotel);
        hotel.setId(hotelDAO.inserir(hotel));

        return "redirect:/hotel/lista";
    }
}
