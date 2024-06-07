package br.com.fiap.inovacao.azul.api.domain.endereco.pais.dto;

import br.com.fiap.inovacao.azul.api.domain.endereco.pais.Pais;

public record DetalhesPaisDTO(Long id, String nomePais, String idd) {

    public DetalhesPaisDTO(Pais pais){
        this(pais.getId(), pais.getNome(), pais.getIdd());
    }
}
