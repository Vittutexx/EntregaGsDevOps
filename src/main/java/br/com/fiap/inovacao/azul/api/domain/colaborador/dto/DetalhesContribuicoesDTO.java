package br.com.fiap.inovacao.azul.api.domain.colaborador.dto;

import br.com.fiap.inovacao.azul.api.domain.contribuicao.RegistroContribuicao;

import java.time.LocalDate;

public record DetalhesContribuicoesDTO(Long id, String descricao, LocalDate dataContribuicao) {

    public DetalhesContribuicoesDTO(RegistroContribuicao registroContribuicao){
        this(registroContribuicao.getId(), registroContribuicao.getDescricao(), registroContribuicao.getData());
    }
}
