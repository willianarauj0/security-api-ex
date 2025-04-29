package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import application.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    @Query("SELECT q FROM Questao q LEFT JOIN FETCH q.opcoes")
    List<Questao> findAllWithOpcoes();
}
