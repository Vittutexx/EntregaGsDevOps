package br.com.fiap.inovacao.azul.api.domain.report.dto;

import br.com.fiap.inovacao.azul.api.domain.usuario.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

public record CriarReportDTO(@NotEmpty
                             String descricao,
                             @NotEmpty
                             String numeroLogradouro,
                             @NotEmpty
                             String nomeLogradouro,
                             @NotEmpty
                             @Length(max = 9)
                             String cep,
                             @NotEmpty
                             String nomeBairro,
                             @NotEmpty
                             String nomeCidade,
                             @NotEmpty
                             String nomeEstado,
                             @NotEmpty
                             @Length(max = 3)
                             String ddd,
                             @NotEmpty
                             String nomePais,
                             @NotEmpty
                             @Length(max = 3)
                             String idd) {
}
