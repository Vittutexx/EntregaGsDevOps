package br.com.fiap.inovacao.azul.api.domain.endereco.cidade;

import br.com.fiap.inovacao.azul.api.domain.endereco.bairro.Bairro;
import br.com.fiap.inovacao.azul.api.domain.endereco.estado.Estado;
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
@Table(name = "GS_INOV_CIDADE")
@SequenceGenerator(name = "seq_gs_cidade", sequenceName = "seq_gs_inov_cidade", allocationSize = 1)
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_cidade")
    @Column(name = "cd_cidade")
    private Long id;

    @Column(name = "nm_cidade", nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "cidadeId")
    private List<Bairro> bairroId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_estado", nullable = false)
    private Estado estadoId;

    public Cidade(CriarUsuarioDTO dto){
        this.nome = dto.nomeCidade();
        bairroId = new ArrayList<>();
    }

    public Cidade(CriarReportDTO dto){
        this.nome = dto.nomeCidade();
        bairroId = new ArrayList<>();
    }
}
