package dev.javacourse.CadastroDeNinjas.Ninjas;

import dev.javacourse.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaDTO {


        private Long id;
        private String nome;
        private String email;
        private int idade;
        private String ranque;
        private MissoesModel missoes;


}
