package br.com.fiap.inovacao.azul.api.domain.ong.dto;

import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.DetalhesColaboradorDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.Ong;

import java.util.ArrayList;
import java.util.List;

public record DetalhesOngDTO(Long id, String name, String description, String email, String telefone, List<DetalhesColaboradorDTO> colaborador) {

    public DetalhesOngDTO(Ong ong) {
        this(ong.getId(), ong.getNome(), ong.getDescricao(), ong.getEmail(), ong.getTelefone(), new ArrayList<>(ong.getOngColaboradorId().stream().map(colab -> new DetalhesColaboradorDTO(colab.getColabId())).toList()));
    }
}
