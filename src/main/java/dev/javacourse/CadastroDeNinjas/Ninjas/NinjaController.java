package dev.javacourse.CadastroDeNinjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/ninjas")
public class NinjaController {

private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
//add ninja

    @PostMapping("/criar")
    public ResponseEntity<?> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoninja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoninja);
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
    public ResponseEntity<?> alteraNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        Map<String, Object> resposta = new LinkedHashMap<>();
        if(ninjaService.listarNinjasPorid(id) != null ){
            resposta.put("mensagem", "Ninja alterado com sucesso");;
            resposta.put("ninja", ninjaAtualizado);
            ninjaService.alterarNinjasPorid(id,ninjaAtualizado);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resposta);
        }
        resposta.put("mensagem", "Erro ao alterar ninja parametro invalido");
        resposta.put("ninja",null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }


    //deletar ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletaNinja(@PathVariable Long id){
        if(ninjaService.listarNinjasPorid(id) != null ){
            ninjaService.deletarNinja(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Ninja deletado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ninja não existe");

    }

}
