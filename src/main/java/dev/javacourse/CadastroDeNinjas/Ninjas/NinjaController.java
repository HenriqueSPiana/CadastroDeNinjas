package dev.javacourse.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //procurar ninja por id

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }


    //Mostrar todos os ninjas
    @GetMapping("/busca")
    public String buscaNinja(){
        return "busca ninja";
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
