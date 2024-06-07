package br.com.fiap.inovacao.azul.api.domain.ong;

import br.com.fiap.inovacao.azul.api.domain.ong.dto.AtualizarOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.CriarOngDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_ONG")
@SequenceGenerator(name = "seq_gs_ong", sequenceName = "seq_gs_inov_ong", allocationSize = 1)
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_ong")
    @Column(name = "cd_ong")
    private Long id;

    @Column(name = "nm_ong", nullable = false, length = 100)
    private String nome;

    @Column(name = "ds_ong", nullable = false, length = 100)
    private String descricao;

    @Column(name = "ds_email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String telefone;

    @OneToMany(mappedBy = "ongId", cascade = CascadeType.REMOVE)
    private List<Usuario> usuarioId;

    @OneToMany(mappedBy = "ongId", cascade = CascadeType.ALL)
    private List<OngColaborador> ongColaboradorId;

    public Ong(CriarOngDTO dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.email = dto.email();
        this.telefone = dto.telefone();
    }

    public void atualizarInformacoes(AtualizarOngDTO dto){
        if(dto.nome() != null){
            this.nome = dto.nome();
        }
        if(dto.descricao() != null){
            this.descricao = dto.descricao();
        }
        if(dto.telefone() != null){
            this.telefone = dto.telefone();
        }
    }
}
