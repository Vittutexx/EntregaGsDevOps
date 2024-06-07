package br.com.fiap.inovacao.azul.api.domain.endereco.estado.dto;

import br.com.fiap.inovacao.azul.api.domain.endereco.estado.Estado;

public record DetalhesEstadoDTO(Long id, String nomeEstado, String ddd) {

    public DetalhesEstadoDTO(Estado estado){
        this(estado.getId(), estado.getNome(), estado.getDdd());
    }
}
