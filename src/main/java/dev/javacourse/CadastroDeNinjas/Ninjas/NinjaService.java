package dev.javacourse.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;


    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    //listar Todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    };



    //listar por ninjas id

    public NinjaModel listarNinjasPorid(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    };



    //criar ninja
    public NinjaModel criarNinja(NinjaModel ninjaModel){

        if(ninjaRepository.existsByEmail(ninjaModel.getEmail())){
            throw new IllegalArgumentException("ja existe um ninja com esse email");
        }
        return ninjaRepository.save(ninjaModel);
    }

    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }



}
