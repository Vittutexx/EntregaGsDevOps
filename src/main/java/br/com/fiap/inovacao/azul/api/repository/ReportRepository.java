package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.helper.Helper;
import br.com.fiap.inovacao.azul.api.domain.helper.HelperReport;
import br.com.fiap.inovacao.azul.api.domain.report.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("from Report r where element(r.reportHelperId).helperId.id = ?1")
    Page<Report> buscarReportsPorHelper(Long id, Pageable pageable);
}
