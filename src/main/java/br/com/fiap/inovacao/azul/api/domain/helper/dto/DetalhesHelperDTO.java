package br.com.fiap.inovacao.azul.api.domain.helper.dto;

import br.com.fiap.inovacao.azul.api.domain.helper.Helper;

public record DetalhesHelperDTO(Long id, String username, String telefone) {

    public DetalhesHelperDTO(Helper helper){
        this(helper.getId(), helper.getNome(), helper.getTelefone());
    }
}
