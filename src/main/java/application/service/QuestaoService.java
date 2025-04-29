package application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Opcao;
import application.model.Questao;
import application.record.QuestaoDTO;
import application.repository.QuestaoRepository;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepository;

    public Questao create(QuestaoDTO dto) {
        // Cria uma nova instância de Questao
        Questao questao = new Questao();
        questao.setEnunciado(dto.enunciado());
        questao.setCategoria(dto.categoria());

        // Primeiro salvamos a questão para obter um ID
        questao = questaoRepository.save(questao);

        // Configuramos as opções e estabelecemos o relacionamento bidirecional
        if (dto.opcoes() != null && !dto.opcoes().isEmpty()) {
            for (Opcao opcao : dto.opcoes()) {
                opcao.setQuestao(questao); // Estabelece a referência para a questão
                questao.getOpcoes().add(opcao); // Adiciona à lista de opções da questão
            }
            // Salvamos novamente para persistir as opções
            questao = questaoRepository.save(questao);
        }

        return questao;
    }

    public List<Questao> findAll() {
        return questaoRepository.findAllWithOpcoes();
    }

}
