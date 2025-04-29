package application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import application.record.CategoriaDTO;
import application.record.OpcaoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "opcoes")
@Getter
@Setter
@NoArgsConstructor
public class Opcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private boolean isCorreta;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questao_id")
    @JsonBackReference
    private Questao questao;


    public Opcao(OpcaoDTO dto) {
        this.id = dto.id();
        this.isCorreta = dto.isCorreta();
        this.questao = dto.questao();
    }
}
