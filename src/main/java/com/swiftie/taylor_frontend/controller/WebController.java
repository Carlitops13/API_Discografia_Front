package com.swiftie.taylor_frontend.controller;

import com.swiftie.taylor_frontend.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    private AlbumService albumService;

  @GetMapping("/") 
public String paginaPrincipal(Model model) {
    System.out.println("--- ENTRANDO A LA PÁGINA PRINCIPAL ---");
    
    var lista = albumService.obtenerTodos();
    System.out.println("Cantidad de álbumes recuperados: " + lista.size());
    
    model.addAttribute("listaAlbumes", lista);
    return "albums"; 
}
}