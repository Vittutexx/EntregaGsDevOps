package br.com.fiap.inovacao.azul.api.domain.endereco.bairro;

import br.com.fiap.inovacao.azul.api.domain.endereco.cidade.Cidade;
import br.com.fiap.inovacao.azul.api.domain.endereco.logradouro.Logradouro;
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
@Table(name = "GS_INOV_BAIRRO")
@SequenceGenerator(name = "seq_gs_bairro", sequenceName = "seq_gs_inov_bairro", allocationSize = 1)
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_bairro")
    @Column(name = "cd_bairro")
    private Long id;

    @Column(name = "nm_bairro", nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "bairroId")
    private List<Logradouro> logradouroId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_cidade", nullable = false)
    private Cidade cidadeId;

    public Bairro(CriarUsuarioDTO dto){
        this.nome = dto.nomeBairro();
        logradouroId = new ArrayList<>();
    }

    public Bairro(CriarReportDTO dto){
        this.nome = dto.nomeBairro();
        logradouroId = new ArrayList<>();
    }

}
