package br.com.fiap.inovacao.azul.api.domain.endereco.bairro.dto;

import br.com.fiap.inovacao.azul.api.domain.endereco.bairro.Bairro;

public record DetalhesBairroDTO(Long id, String nomeBairro) {

    public DetalhesBairroDTO(Bairro bairro){
        this(bairro.getId(), bairro.getNome());
    }
}
