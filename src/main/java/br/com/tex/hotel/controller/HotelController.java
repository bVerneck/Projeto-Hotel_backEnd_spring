package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.HotelDAO;
import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.dto.HotelInputAlteraDTO;
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
    private HotelDAO dao;

    @GetMapping("/lista")
    public String listHoteis(Model model){
        model.addAttribute("list", dao.listAllHotel());
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

        dao.inserir(hotelInputDTO.toHotel(hotelInputDTO));
        redirectAttributes.addFlashAttribute("sucess", "Hotel cadastrado com sucesso!");
        return "redirect:/hotel/lista";
    }

    @GetMapping("/detalhe")
    public String mostrarDetalhe(@RequestParam("id") Integer id, Model model){
        model.addAttribute("hotel", new HotelOutputDetalheDTO(dao.getById(id)));
        return "detalheHotel";
    }

    @Transactional
    @GetMapping("/deleta/{id}")
    public String deleta(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        dao.delete(dao.getById(id));
        redirectAttributes.addFlashAttribute("sucess", "Hotel excluído com sucesso!");
        return "redirect:/hotel/lista";
    }

    @GetMapping("/preparaAlterar/{id}")
    public String preparaAlterar(@PathVariable Integer id, Model model){
        model.addAttribute("hotel", dao.getById(id));
        model.addAttribute("tipoLogradouros", TipoLogradouro.values());
        model.addAttribute("estados", Estado.values());

        return "formAlteraHotel";
    }

    @Transactional
    @PostMapping("/altera")
    public String altera(HotelInputAlteraDTO dto, RedirectAttributes redirectAttributes){
        System.out.println(dto);
        dao.alterar(dao.getById(dto.getId()), dto);

        redirectAttributes.addFlashAttribute("sucess", "Hotel alterado com sucesso!");

        return "redirect:/hotel/lista";
    }
}
