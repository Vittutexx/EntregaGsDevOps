package br.com.fiap.inovacao.azul.api.domain.colaborador.dto;

import br.com.fiap.inovacao.azul.api.domain.colaborador.Colaborador;
import br.com.fiap.inovacao.azul.api.domain.colaborador.StatusColaborador;

import java.util.stream.Collectors;

public record ListagemColaboradorDTO(Long id, String nome, StatusColaborador status, String telefone, String nomeOng) {

    public ListagemColaboradorDTO(Colaborador colaborador){
        this(colaborador.getId(), colaborador.getNome(), colaborador.getStatus(), colaborador.getTelefone(), colaborador.getOngColaboradorId().stream().map(c -> c.getOngId().getNome()).collect(Collectors.joining()));
    }
}
