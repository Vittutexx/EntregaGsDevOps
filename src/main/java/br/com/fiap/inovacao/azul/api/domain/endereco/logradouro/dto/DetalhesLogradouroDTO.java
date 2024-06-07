package br.com.fiap.inovacao.azul.api.domain.endereco.logradouro.dto;

import br.com.fiap.inovacao.azul.api.domain.endereco.logradouro.Logradouro;

public record DetalhesLogradouroDTO(Long id, String logradouro, String cep) {

    public DetalhesLogradouroDTO(Logradouro logradouro){
        this(logradouro.getId(), logradouro.getLogradouro(), logradouro.getCep());
    }
}
