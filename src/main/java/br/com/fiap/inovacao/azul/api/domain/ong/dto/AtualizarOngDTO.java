package br.com.fiap.inovacao.azul.api.domain.ong.dto;

import org.hibernate.validator.constraints.Length;

public record AtualizarOngDTO(String nome,
                              String descricao,
                              @Length(max = 15)
                              String telefone) {
}
