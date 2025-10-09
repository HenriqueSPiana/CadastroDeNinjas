package dev.javacourse.CadastroDeNinjas.Ninjas;

import dev.javacourse.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<MissoesModel, Long> {

}
