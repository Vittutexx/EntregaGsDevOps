package br.com.fiap.inovacao.azul.api.service;

import br.com.fiap.inovacao.azul.api.domain.colaborador.Colaborador;
import br.com.fiap.inovacao.azul.api.domain.colaborador.StatusColaborador;
import br.com.fiap.inovacao.azul.api.domain.endereco.Endereco;
import br.com.fiap.inovacao.azul.api.domain.endereco.cidade.Cidade;
import br.com.fiap.inovacao.azul.api.domain.endereco.pais.Pais;
import br.com.fiap.inovacao.azul.api.domain.endereco.bairro.Bairro;
import br.com.fiap.inovacao.azul.api.domain.endereco.logradouro.Logradouro;
import br.com.fiap.inovacao.azul.api.domain.endereco.estado.Estado;
import br.com.fiap.inovacao.azul.api.domain.ong.OngColaborador;
import br.com.fiap.inovacao.azul.api.domain.usuario.Usuario;
import br.com.fiap.inovacao.azul.api.domain.usuario.TipoUsuario;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.CriarUsuarioDTO;
import br.com.fiap.inovacao.azul.api.repository.ColaboradorRepository;
import br.com.fiap.inovacao.azul.api.repository.OngColaboradorRepository;
import br.com.fiap.inovacao.azul.api.repository.OngRepository;
import br.com.fiap.inovacao.azul.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private OngColaboradorRepository ongColaboradorRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public Usuario criarUsuario(CriarUsuarioDTO dto){
        var user = new Usuario(dto);
        var endereco = new Endereco(dto);
        var logradouro = new Logradouro(dto);
        var bairro = new Bairro(dto);
        var cidade = new Cidade(dto);
        var estado = new Estado(dto);
        var pais = new Pais(dto);

        user.setTipoUsuario(TipoUsuario.COMUM);

        endereco.setUsuarioId(user);
        user.setEnderecoId(endereco);

        endereco.setLogradouroId(logradouro);
        logradouro.getEnderecoId().add(endereco);

        logradouro.setBairroId(bairro);
        bairro.getLogradouroId().add(logradouro);

        bairro.setCidadeId(cidade);
        cidade.getBairroId().add(bairro);

        cidade.setEstadoId(estado);
        estado.getCidadeId().add(cidade);

        estado.setPaisId(pais);
        pais.getEstadoId().add(estado);

        usuarioRepository.save(user);
        return user;
    }

    public void excluirUsuario(Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        if(usuario.getTipoUsuario() == TipoUsuario.COLABORADOR){
            colaboradorRepository.deleteById(id);
        } else {
            usuarioRepository.delete(usuario);
        }
    }

    public Usuario adicionarOng(Long idUsuario, Long idOng){
        var usuario = usuarioRepository.getReferenceById(idUsuario);
        var ong = ongRepository.getReferenceById(idOng);

        usuario.setOngId(ong);
        usuario.setTipoUsuario(TipoUsuario.COLABORADOR);
        ong.getUsuarioId().add(usuario);


        var colaborador = new Colaborador();
        colaborador.setNome(usuario.getNome());
        colaborador.setStatus(StatusColaborador.ATIVO);
        colaborador.setTelefone(usuario.getHelperId().getTelefone());

        var ongColaborador = new OngColaborador();
        ongColaborador.setOngId(ong);
        ongColaborador.setColabId(colaborador);

        usuarioRepository.save(usuario);
        ongRepository.save(ong);
        colaboradorRepository.save(colaborador);
        ongColaboradorRepository.save(ongColaborador);
        return usuario;
    }
}
