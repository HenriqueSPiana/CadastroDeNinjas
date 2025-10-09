package dev.javacourse.CadastroDeNinjas.Missoes;

import dev.javacourse.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.LinkedList;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //uma missão pode ter varios ninjas, porem um ninja so pode ter uma missao
    @OneToMany(mappedBy = "missoes")
    private LinkedList<NinjaModel> ninjas;

}
