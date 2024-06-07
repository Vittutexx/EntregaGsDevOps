package br.com.fiap.inovacao.azul.api.domain.usuario.dto;

import br.com.fiap.inovacao.azul.api.domain.usuario.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

public record CriarUsuarioDTO(
        @NotEmpty
        String nome,
        @NotEmpty
        String username,
        @NotEmpty
        @Email
        String email,
        @NotEmpty
        @Length(max = 15)
        String telefone,
        @NotEmpty
        @Length(max = 10)
        String senha,
        @NotEmpty
        String numeroLogradouro,
        @NotEmpty
        String nomeLogradouro,
        @NotEmpty
        String cep,
        @NotEmpty
        String nomeBairro,
        @NotEmpty
        String nomeCidade,
        @NotEmpty
        String nomeEstado,
        @NotEmpty
        String ddd,
        @NotEmpty
        String nomePais,
        @NotEmpty
        String idd) {
}
