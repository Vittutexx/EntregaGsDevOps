package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.contribuicao.RegistroContribuicao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistroContribuicaoRepository extends JpaRepository<RegistroContribuicao, Long> {

    @Query("select(rc) from RegistroContribuicao rc where rc.colabId.id = ?1")
    RegistroContribuicao pesquisarPorContribuicoesFeitas(Long id);
}
