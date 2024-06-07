package br.com.fiap.inovacao.azul.api.domain.colaborador.dto;

import br.com.fiap.inovacao.azul.api.domain.colaborador.Colaborador;

public record DetalhesColaboradorDTO(Long id, String nome, String telefone, Long contribuicoes) {

    public DetalhesColaboradorDTO(Colaborador colaborador){
        this(colaborador.getId(), colaborador.getNome(), colaborador.getTelefone(), colaborador.getContribuicoesId().stream().count());
    }

}
