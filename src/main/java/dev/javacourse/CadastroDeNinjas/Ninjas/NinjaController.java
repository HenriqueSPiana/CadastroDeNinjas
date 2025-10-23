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

    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel){
        var ninja = ninjaService.criarNinja(ninjaModel);
        return ninja;
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
