package dev.javacourse.CadastroDeNinjas.Ninjas;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NinjaMapper {


    NinjaModel map(NinjaDTO ninjaDTO);

    NinjaDTO map(NinjaModel ninjaModel);

}
