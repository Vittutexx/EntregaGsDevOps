package br.com.fiap.inovacao.azul.api.domain.helper;

import br.com.fiap.inovacao.azul.api.domain.report.Report;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_HELPER_REPORT")
@SequenceGenerator(name = "seq_gs_helper_report", sequenceName = "seq_gs_inov_helper_report", allocationSize = 1)
public class HelperReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_helper_report")
    @Column(name = "cd_helper_report")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_helper", nullable = false)
    private Helper helperId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_report", nullable = false)
    private Report reportId;
}
