package br.com.fiap.inovacao.azul.api.domain.endereco;

import br.com.fiap.inovacao.azul.api.domain.endereco.logradouro.Logradouro;
import br.com.fiap.inovacao.azul.api.domain.report.Report;
import br.com.fiap.inovacao.azul.api.domain.report.dto.CriarReportDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.Usuario;
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
@Table(name = "GS_INOV_ENDERECO")
@SequenceGenerator(name = "seq_gs_endereco", sequenceName = "seq_gs_inov_endereco", allocationSize = 1)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_endereco")
    @Column(name = "cd_endereco")
    private Long id;

    @Column(name = "nr_logradouro", nullable = false, length = 20)
    private String numeroLogradouro;

    @OneToOne(mappedBy = "enderecoId")
    private Usuario usuarioId;

    @OneToMany(mappedBy = "enderecoId")
    private List<Report> reportId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_logradouro", nullable = false)
    private Logradouro logradouroId;

    public Endereco(CriarUsuarioDTO dto){
        this.numeroLogradouro = dto.numeroLogradouro();
    }

    public Endereco(CriarReportDTO dto){
        this.numeroLogradouro = dto.numeroLogradouro();
        reportId = new ArrayList<>();
    }

}
