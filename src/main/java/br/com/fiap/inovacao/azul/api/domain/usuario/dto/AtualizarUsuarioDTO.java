package br.com.fiap.inovacao.azul.api.domain.usuario.dto;

import org.hibernate.validator.constraints.Length;

public record AtualizarUsuarioDTO(
        @Length(max = 10)
        String senha,
        String username,
        @Length(max = 15)
        String telefone) {
}
