package br.com.fiap.inovacao.azul.api.domain.usuario.dto;

import br.com.fiap.inovacao.azul.api.domain.ong.dto.DetalhesOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.ListagemOngDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.TipoUsuario;
import br.com.fiap.inovacao.azul.api.domain.usuario.Usuario;

public record ListagemUsuarioDTO(Long id, String nome, String email, TipoUsuario tipoUsuario, String telefone, ListagemOngDTO ong) {

    public ListagemUsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipoUsuario(), usuario.getHelperId().getTelefone(), usuario.getOngId() != null ? new ListagemOngDTO(usuario.getOngId()) : null);
    }
}
