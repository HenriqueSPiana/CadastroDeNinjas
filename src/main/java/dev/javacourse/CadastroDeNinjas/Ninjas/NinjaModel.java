package dev.javacourse.CadastroDeNinjas.Ninjas;


import dev.javacourse.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.LinkedList;

@Entity
@Table(name = "tb_cadastro")
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

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        Idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }
}
