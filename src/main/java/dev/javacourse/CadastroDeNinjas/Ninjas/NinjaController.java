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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);

    }

    //Mostrar todos os ninjas

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
//        List<NinjaDTO> listaNinja = ninjaService.listarNinjas();
        return ninjaService.listarNinjas();
    }


    //procurar ninja por id

    @GetMapping("/listar/{id}")
    public NinjaDTO buscaNinja(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorid(id);
        return ninja;
    }

    //alterar ninja

    @PutMapping("/alterar/{id}")
    public NinjaDTO alteraNinja(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.alterarNinjasPorid(id,ninjaAtualizado);
    }


    //deletar ninja
    @DeleteMapping("/deletar/{id}")
    public void deletaNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }

}
