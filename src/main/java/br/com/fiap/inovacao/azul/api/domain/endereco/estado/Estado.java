package br.com.fiap.inovacao.azul.api.domain.endereco.estado;

import br.com.fiap.inovacao.azul.api.domain.endereco.cidade.Cidade;
import br.com.fiap.inovacao.azul.api.domain.endereco.pais.Pais;
import br.com.fiap.inovacao.azul.api.domain.report.dto.CriarReportDTO;
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
@Table(name = "GS_INOV_ESTADO")
@SequenceGenerator(name = "seq_gs_estado", sequenceName = "seq_gs_inov_estado", allocationSize = 1)
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_estado")
    @Column(name = "cd_estado")
    private Long id;

    @Column(name = "nm_estado", nullable = false, length = 100)
    private String nome;

    @Column(name = "nr_ddd", nullable = false, length = 2)
    private String ddd;

    @OneToMany(mappedBy = "estadoId")
    private List<Cidade> cidadeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_pais", nullable = false)
    private Pais paisId;

    public Estado(CriarUsuarioDTO dto){
        this.nome = dto.nomeEstado();
        this.ddd = dto.ddd();
        cidadeId = new ArrayList<>();
    }

    public Estado(CriarReportDTO dto){
        this.nome = dto.nomeEstado();
        this.ddd = dto.ddd();
        cidadeId = new ArrayList<>();
    }
}
