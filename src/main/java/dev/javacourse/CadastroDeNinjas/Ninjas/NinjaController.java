package dev.javacourse.CadastroDeNinjas.Ninjas;


import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
//add ninja

    @PostMapping("/adiciona")
    public String adicionaNinja(){
        return "ninja adicionado";
    }

    //Mostrar todos os ninjas

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        List<NinjaModel> listaNinja = ninjaService.listarNinjas();
        return listaNinja;
    }


    //procurar ninja por id

    @GetMapping("/listar/{id}")
    public NinjaModel buscaNinja(@PathVariable Long id){
        NinjaModel ninja = ninjaService.listarNinjasPorid(id);
        return ninja;
    }

    //alterar ninja

    @PutMapping("/altera")
    public String alteraNinja(){
        return "altera ninja";
    }


    //deletar ninja
    @DeleteMapping("/deleta")
    public String deletaNinja(){
        return "deleta ninja";
    }

}
