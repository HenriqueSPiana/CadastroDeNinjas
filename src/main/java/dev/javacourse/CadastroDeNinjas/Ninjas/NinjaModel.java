package dev.javacourse.CadastroDeNinjas.Ninjas;


import dev.javacourse.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int Idade;

    //um ninja com uma unica missão, porem são varios ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")// foreing Key ou chave estangeira
    private MissoesModel missoes;

}
