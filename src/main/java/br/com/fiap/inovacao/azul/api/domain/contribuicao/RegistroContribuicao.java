package br.com.fiap.inovacao.azul.api.domain.contribuicao;

import br.com.fiap.inovacao.azul.api.domain.colaborador.Colaborador;
import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.RegistroContribuicaoDTO;
import br.com.fiap.inovacao.azul.api.domain.report.dto.CriarReportDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_REGISTRO_CONTRIBUICAO")
@SequenceGenerator(name = "seq_gs_contribuicao", sequenceName = "seq_gs_inov_contribuicao", allocationSize = 1)
@EntityListeners(AuditingEntityListener.class)
public class RegistroContribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_contribuicao")
    @Column(name = "cd_contribuicao")
    private Long id;

    @Column(name = "ds_contribuicao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "dt_contribuicao", nullable = false)
    @CreatedDate
    private LocalDate data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_colaborador")
    private Colaborador colabId;

    public RegistroContribuicao(RegistroContribuicaoDTO dto){
        this.descricao = dto.descricao();
    }

}
