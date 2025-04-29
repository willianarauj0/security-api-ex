package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Questao;
import application.record.QuestaoDTO;
import application.service.QuestaoService;

@RestController
@RequestMapping("questoes")
public class QuestaoController {
    
    @Autowired
    private QuestaoService questaoService;
    
    @PostMapping()
    public Questao create (@RequestBody QuestaoDTO dto) {
        return questaoService.create(dto);
    }

    @GetMapping()
    public List<Questao> findAll () {
        return questaoService.findAll();
    }
}
