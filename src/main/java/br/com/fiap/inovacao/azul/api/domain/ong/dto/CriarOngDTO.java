package br.com.fiap.inovacao.azul.api.domain.ong.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record CriarOngDTO(
        @NotEmpty
        String nome,
        @NotEmpty
        String descricao,
        @NotEmpty
        @Email
        String email,
        @NotEmpty
        @Length(max = 15)
        String telefone) {
}
