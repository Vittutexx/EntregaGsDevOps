package br.com.fiap.inovacao.azul.api.controller;

import br.com.fiap.inovacao.azul.api.domain.ong.Ong;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.AtualizarOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.CriarOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.DetalhesOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.ListagemOngDTO;
import br.com.fiap.inovacao.azul.api.repository.OngColaboradorRepository;
import br.com.fiap.inovacao.azul.api.repository.OngRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    private OngRepository ongRepository;

    @Operation(summary = "Cadastra uma ONG")
    @PostMapping
    @Transactional
    public ResponseEntity<ListagemOngDTO> criar(@RequestBody @Valid CriarOngDTO dto, UriComponentsBuilder builder){
        var ong = new Ong(dto);
        var uri = builder.path("/{id}").buildAndExpand(ong.getId()).toUri();
        ongRepository.save(ong);
        return ResponseEntity.created(uri).body(new ListagemOngDTO(ong));
    }

    @Operation(summary = "Mostra os detalhes da ONG específica")
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesOngDTO> detalhesOng(@PathVariable Long id){
        var ongs = ongRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesOngDTO(ongs));
    }

    @Operation(summary = "Lista todas as ONGs cadastradas")
    @GetMapping
    public ResponseEntity<Page<ListagemOngDTO>> listar(@ParameterObject @PageableDefault(size = 5) Pageable pageable){
        var lista = ongRepository.findAll(pageable).map(ListagemOngDTO::new);
        return ResponseEntity.ok(lista);
    }

    @Operation(summary = "Atualiza ONG específica")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesOngDTO> atualizar(@RequestBody @Valid AtualizarOngDTO dto, @PathVariable Long id){
        var ong = ongRepository.getReferenceById(id);
        ong.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesOngDTO(ong));
    }

    @Operation(summary = "Exclui ONG específica")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesOngDTO> excluir(@PathVariable Long id){
        ongRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
