package br.com.tex.hotel.controller;

import br.com.tex.hotel.dao.HotelDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.sql.SQLException;

/**
 * @author Willian
 */
@Controller
public class HotelController {

    @GetMapping("/hoteis")
    public String listHoteis(Model modell){
        HotelDAO hotelDAO = new HotelDAO();
        modell.addAttribute("list", hotelDAO.listAllHotel());

        return "listHoteis";
    }
}
