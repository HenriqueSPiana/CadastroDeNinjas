package dev.javacourse.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
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

private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }
//add ninja
    @Operation(summary = "Criar ninja",
        description = "Cria o ninja no sistema")
    @PostMapping("/criar")
    public ResponseEntity<?> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoninja =  ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoninja);
    }

    @Operation(summary = "Lista ninjas",
            description = "Lista todos os ninjas cadastrados")
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Integer idade,
            @RequestParam(required = false) String ranque
    ){
        return ninjaService.listarNinjas(nome,idade,ranque);
    }

    @Operation(summary = "Lista ninjas por ID",
            description = "Lista o ninja correspondente ao ID")
    @GetMapping("/listar/{id}")
    public NinjaDTO buscaNinja(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorid(id);
        return ninja;
    }

    //alterar ninja
    @Operation(summary = "Altera ninjas por ID",
            description = "altera o ninja correspondente ao ID")
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


    @Operation(summary = "Deleta ninjas por ID",
            description = "Deleta o ninja correspondente ao ID")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletaNinja(@PathVariable Long id){
        if(ninjaService.listarNinjasPorid(id) != null ){
            ninjaService.deletarNinja(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Ninja deletado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ninja não existe");

    }

}
