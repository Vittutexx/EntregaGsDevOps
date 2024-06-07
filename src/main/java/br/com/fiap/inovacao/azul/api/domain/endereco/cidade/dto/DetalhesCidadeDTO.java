package br.com.fiap.inovacao.azul.api.domain.endereco.cidade.dto;

import br.com.fiap.inovacao.azul.api.domain.endereco.cidade.Cidade;

public record DetalhesCidadeDTO(Long id, String nomeCidade) {

    public DetalhesCidadeDTO(Cidade cidade){
        this(cidade.getId(), cidade.getNome());
    }
}
