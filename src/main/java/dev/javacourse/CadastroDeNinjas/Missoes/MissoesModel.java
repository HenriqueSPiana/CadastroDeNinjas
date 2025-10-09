package dev.javacourse.CadastroDeNinjas.Missoes;

import dev.javacourse.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
