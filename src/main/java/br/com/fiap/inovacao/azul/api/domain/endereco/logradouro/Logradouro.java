package br.com.fiap.inovacao.azul.api.domain.endereco.logradouro;

import br.com.fiap.inovacao.azul.api.domain.endereco.Endereco;
import br.com.fiap.inovacao.azul.api.domain.endereco.bairro.Bairro;
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
@Table(name = "GS_INOV_LOGRADOURO")
@SequenceGenerator(name = "seq_gs_logradouro", sequenceName = "seq_gs_inov_logradouro", allocationSize = 1)
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_logradouro")
    @Column(name = "cd_logradouro")
    private Long id;

    @Column(name = "ds_logradouro", nullable = false, length = 100)
    private String logradouro;

    @Column(name = "nr_cep", nullable = false, length = 9)
    private String cep;

    @OneToMany(mappedBy = "logradouroId")
    private List<Endereco> enderecoId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_bairro", nullable = false)
    private Bairro bairroId;

    public Logradouro(CriarUsuarioDTO dto){
        this.logradouro = dto.nomeLogradouro();
        this.cep = dto.cep();
        enderecoId = new ArrayList<>();
    }

    public Logradouro(CriarReportDTO dto){
        this.logradouro = dto.numeroLogradouro();
        this.cep = dto.cep();
        enderecoId = new ArrayList<>();
    }

}
