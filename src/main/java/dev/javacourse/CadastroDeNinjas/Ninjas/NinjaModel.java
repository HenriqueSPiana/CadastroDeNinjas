package dev.javacourse.CadastroDeNinjas.Ninjas;


import dev.javacourse.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true,name = "email")
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "ranque")
    private String ranque;

    //um ninja com uma unica missão, porem são varios ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")// foreing Key ou chave estangeira
    private MissoesModel missoes;

}
