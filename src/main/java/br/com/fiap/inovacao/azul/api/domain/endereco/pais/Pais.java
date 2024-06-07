package br.com.fiap.inovacao.azul.api.domain.endereco.pais;

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
@Table(name = "GS_INOV_PAIS")
@SequenceGenerator(name = "seq_gs_pais", sequenceName = "seq_gs_inov_pais", allocationSize = 1)
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_pais")
    @Column(name = "cd_pais")
    private Long id;

    @Column(name = "nm_pais", nullable = false, length = 100)
    private String nome;

    @Column(name = "cd_telefone_pais", nullable = false, length = 3)
    private String idd;

    @OneToMany(mappedBy = "paisId")
    private List<Estado> estadoId;

    public Pais(CriarUsuarioDTO dto){
        this.nome = dto.nomePais();
        this.idd = dto.idd();
        estadoId = new ArrayList<>();
    }

    public Pais(CriarReportDTO dto){
        this.nome = dto.nomePais();
        this.idd = dto.idd();
        estadoId = new ArrayList<>();
    }
}
