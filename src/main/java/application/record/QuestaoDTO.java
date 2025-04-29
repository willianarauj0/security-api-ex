package application.record;

import java.util.List;

import application.model.Categoria;
import application.model.Opcao;

public record QuestaoDTO(long id, String enunciado, List<Opcao> opcoes, Categoria categoria) {
    
}
