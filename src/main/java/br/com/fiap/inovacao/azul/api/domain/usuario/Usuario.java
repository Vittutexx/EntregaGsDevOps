package br.com.fiap.inovacao.azul.api.domain.usuario;

import br.com.fiap.inovacao.azul.api.domain.endereco.Endereco;
import br.com.fiap.inovacao.azul.api.domain.helper.Helper;
import br.com.fiap.inovacao.azul.api.domain.ong.Ong;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.AtualizarUsuarioDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.CriarUsuarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_USUARIO")
@SequenceGenerator(name = "seq_gs_usuario", sequenceName = "seq_gs_inov_usuario", allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_usuario")
    @Column(name = "cd_usuario")
    private Long id;

    @Column(name = "nm_usuario", nullable = false, length = 100)
    private String nome;

    @Column(name = "ds_email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "ds_senha", nullable = false, length = 10)
    private String senha;

    @Column(name = "tp_usuario", nullable = false, length = 11)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @OneToOne(mappedBy = "usuarioId", cascade = CascadeType.ALL)
    private Helper helperId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cd_ong")
    private Ong ongId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_endereco", nullable = false)
    private Endereco enderecoId;

    public Usuario(CriarUsuarioDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();

        var helper = new Helper(dto);
        helper.setUsuarioId(this);
        this.helperId = helper;
    }

    public void atualizarInformacoes(AtualizarUsuarioDTO dto){
        if(dto.senha() != null){
            this.senha = dto.senha();
        }
        if(dto.username() != null){
            this.helperId.setNome(dto.username());
        }
        if(dto.telefone() != null){
            this.helperId.setTelefone(dto.telefone());
        }
    }
}
