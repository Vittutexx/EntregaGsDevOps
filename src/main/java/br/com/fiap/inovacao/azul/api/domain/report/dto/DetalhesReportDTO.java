package br.com.fiap.inovacao.azul.api.domain.report.dto;

import br.com.fiap.inovacao.azul.api.domain.endereco.dto.DetalhesEnderecoDTO;
import br.com.fiap.inovacao.azul.api.domain.report.Report;
import br.com.fiap.inovacao.azul.api.domain.report.StatusReport;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DetalhesReportDTO(Long id, String descricao,
                                @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                LocalDateTime dataRegistro,
                                StatusReport status,
                                @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                LocalDateTime dataFinalizacao,
                                DetalhesEnderecoDTO endereco) {

    public DetalhesReportDTO(Report report){
        this(report.getId(), report.getDescricao(), report.getDataRegistro(), report.getStatus(),
                report.getDataFinalizacao(), new DetalhesEnderecoDTO(report.getEnderecoId()));
    }
}
