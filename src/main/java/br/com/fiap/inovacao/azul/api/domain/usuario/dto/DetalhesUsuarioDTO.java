package br.com.fiap.inovacao.azul.api.domain.usuario.dto;

import br.com.fiap.inovacao.azul.api.domain.endereco.dto.DetalhesEnderecoDTO;
import br.com.fiap.inovacao.azul.api.domain.helper.dto.DetalhesHelperDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.DetalhesOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.ListagemOngDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.Usuario;
import br.com.fiap.inovacao.azul.api.domain.usuario.TipoUsuario;

public record DetalhesUsuarioDTO(Long userId, String user, ListagemOngDTO ong, String email, String senha, TipoUsuario tipoUsuario, DetalhesHelperDTO helper, DetalhesEnderecoDTO endereco) {

    public DetalhesUsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getOngId() != null ? new ListagemOngDTO(usuario.getOngId()) : null, usuario.getEmail(), usuario.getSenha(), usuario.getTipoUsuario(), new DetalhesHelperDTO(usuario.getHelperId()), new DetalhesEnderecoDTO(usuario.getEnderecoId()));
    }
}
