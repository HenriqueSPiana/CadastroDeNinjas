package dev.javacourse.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //listar Todos os ninjas
    public List<NinjaDTO> listarNinjas(String nome, Integer idade, String ranque){

        List<NinjaModel> ninjas = ninjaRepository.findNinjasComFiltros(nome, idade, ranque);
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());

    };



    //listar por ninjas id

    public NinjaDTO listarNinjasPorid(Long id){

        Optional<NinjaModel> ninjaPorid = ninjaRepository.findById(id);
        return ninjaPorid.map(ninjaMapper::map).orElse(null);

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

    public NinjaDTO alterarNinjasPorid(Long id, NinjaDTO ninjaDTO){

        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        if(ninja.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            return ninjaMapper.map(ninjaRepository.save(ninjaAtualizado));

        }
        return null;


    };


}
