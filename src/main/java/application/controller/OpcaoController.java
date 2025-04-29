package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Opcao;
import application.record.OpcaoDTO;
import application.service.OpcaoService;

@RestController
@RequestMapping("opcoes")
public class OpcaoController {
    
    @Autowired
    private OpcaoService opcaoService;
    
    @PostMapping()
    public Opcao create (@RequestBody OpcaoDTO dto) {
        return opcaoService.create(dto);
    }

    @GetMapping()
    public List<Opcao> findAll () {
        return opcaoService.findAll();
    }
}
