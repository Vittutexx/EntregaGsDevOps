package br.com.fiap.inovacao.azul.api.domain.colaborador;

import br.com.fiap.inovacao.azul.api.domain.contribuicao.RegistroContribuicao;
import br.com.fiap.inovacao.azul.api.domain.ong.OngColaborador;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.CriarUsuarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_COLABORADOR")
@SequenceGenerator(name = "seq_gs_colaborador", sequenceName = "seq_gs_inov_colaborador", allocationSize = 1)
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_colaborador")
    @Column(name = "cd_colaborador")
    private Long id;

    @Column(name = "nm_colaborador", nullable = false, length = 100)
    private String nome;

    @Column(name = "st_colaborador", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private StatusColaborador status;

    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String telefone;

    @OneToMany(mappedBy = "colabId", cascade = CascadeType.ALL)
    private List<OngColaborador> ongColaboradorId;

    @OneToMany(mappedBy = "colabId", cascade = CascadeType.ALL)
    private List<RegistroContribuicao> contribuicoesId;

    @OneToMany(mappedBy = "colaboradorId", cascade = CascadeType.ALL)
    private List<ColaboradorReport> colaboradorReportId;

    public Colaborador(CriarUsuarioDTO dto){
        this.nome = dto.username();
        this.status = StatusColaborador.ATIVO;
        this.telefone = dto.telefone();
        colaboradorReportId = new ArrayList<>();
    }

    public void marcarInativo(){
        this.status = StatusColaborador.INATIVO;
    }

}
