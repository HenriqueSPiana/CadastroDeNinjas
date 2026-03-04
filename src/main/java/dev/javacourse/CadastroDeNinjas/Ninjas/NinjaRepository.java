package dev.javacourse.CadastroDeNinjas.Ninjas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {

    @Query("SELECT n FROM NinjaModel n WHERE " +
            "(:nome IS NULL OR n.nome LIKE %:nome%) AND " +
            "(:idade IS NULL OR n.idade = :idade) AND " +
            "(:ranque IS NULL OR n.ranque = :ranque)")
    List<NinjaModel> findNinjasComFiltros(@Param("nome") String nome,
                                          @Param("idade") Integer idade,
                                          @Param("ranque") String ranque);

}
