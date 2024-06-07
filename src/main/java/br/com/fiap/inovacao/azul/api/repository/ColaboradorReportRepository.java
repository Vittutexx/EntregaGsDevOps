package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.colaborador.ColaboradorReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorReportRepository extends JpaRepository<ColaboradorReport, Long> {
}
