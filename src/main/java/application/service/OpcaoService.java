package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.model.Opcao;
import application.record.OpcaoDTO;
import application.repository.OpcaoRepository;

@Service
public class OpcaoService {
    @Autowired
    private OpcaoRepository opcaoRepository;

    public Opcao create(OpcaoDTO dto) {
        Opcao opcao = new Opcao();
        opcao.setCorreta(dto.isCorreta());
        opcao.setDescricao(dto.descricao());
        opcao.setQuestao(dto.questao());
        return opcaoRepository.save(opcao);
    }

    public List<Opcao> findAll() {
        return opcaoRepository.findAll();
    }
}
