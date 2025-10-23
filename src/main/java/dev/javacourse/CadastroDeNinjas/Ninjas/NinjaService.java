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

    public NinjaModel listarNinjasPorid(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    };

    public NinjaModel criarNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }



}
