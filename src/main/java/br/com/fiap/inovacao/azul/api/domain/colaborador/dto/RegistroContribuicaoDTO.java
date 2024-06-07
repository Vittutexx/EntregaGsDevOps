package br.com.fiap.inovacao.azul.api.domain.colaborador.dto;

import br.com.fiap.inovacao.azul.api.domain.contribuicao.RegistroContribuicao;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistroContribuicaoDTO(
        @NotEmpty
        String descricao) {
}
