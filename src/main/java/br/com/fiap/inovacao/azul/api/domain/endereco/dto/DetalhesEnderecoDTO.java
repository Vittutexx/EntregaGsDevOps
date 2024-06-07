package br.com.fiap.inovacao.azul.api.domain.endereco.dto;

import br.com.fiap.inovacao.azul.api.domain.endereco.Endereco;
import br.com.fiap.inovacao.azul.api.domain.endereco.cidade.dto.DetalhesCidadeDTO;
import br.com.fiap.inovacao.azul.api.domain.endereco.pais.dto.DetalhesPaisDTO;
import br.com.fiap.inovacao.azul.api.domain.endereco.bairro.dto.DetalhesBairroDTO;
import br.com.fiap.inovacao.azul.api.domain.endereco.logradouro.dto.DetalhesLogradouroDTO;
import br.com.fiap.inovacao.azul.api.domain.endereco.estado.dto.DetalhesEstadoDTO;

public record DetalhesEnderecoDTO(Long id, DetalhesLogradouroDTO logradouro, DetalhesBairroDTO bairro, DetalhesCidadeDTO cidade, DetalhesEstadoDTO estado, DetalhesPaisDTO pais) {

    public DetalhesEnderecoDTO(Endereco endereco){
        this(endereco.getId(), new DetalhesLogradouroDTO(endereco.getLogradouroId()),
                new DetalhesBairroDTO(endereco.getLogradouroId().getBairroId()),
                new DetalhesCidadeDTO(endereco.getLogradouroId().getBairroId().getCidadeId()),
                new DetalhesEstadoDTO(endereco.getLogradouroId().getBairroId().getCidadeId().getEstadoId()),
                new DetalhesPaisDTO(endereco.getLogradouroId().getBairroId().getCidadeId().getEstadoId().getPaisId()));
    }
}
