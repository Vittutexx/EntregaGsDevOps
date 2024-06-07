package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.colaborador.Colaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("from Colaborador c where c.status = 'INATIVO'")
    Page<Colaborador> pesquisarColaboradoresInativos(Pageable pageable);
}
