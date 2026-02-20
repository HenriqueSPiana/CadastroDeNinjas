package dev.javacourse.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){

        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);

    }

    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }


    //alterar ninja id

    public NinjaModel alterarNinjasPorid(Long id, NinjaModel ninjaAtualizado){

        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        };

        return null;
    };


}
