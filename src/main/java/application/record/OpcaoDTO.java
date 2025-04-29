package application.record;

import application.model.Questao;

public record OpcaoDTO (long id, String descricao, boolean isCorreta, Questao questao) {
    
}
