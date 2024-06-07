package br.com.fiap.inovacao.azul.api.controller;

import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.DetalhesColaboradorDTO;
import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.DetalhesContribuicoesDTO;
import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.ListagemColaboradorDTO;
import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.RegistroContribuicaoDTO;
import br.com.fiap.inovacao.azul.api.repository.ColaboradorRepository;
import br.com.fiap.inovacao.azul.api.repository.RegistroContribuicaoRepository;
import br.com.fiap.inovacao.azul.api.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private RegistroContribuicaoRepository registroContribuicaoRepository;

    @Autowired
    private ReportService reportService;


    @Operation(summary = "Lista todos os colaboradores existentes")
    @GetMapping
    public ResponseEntity<Page<ListagemColaboradorDTO>> listar(@ParameterObject @PageableDefault(size = 5) Pageable pageable){
        var lista = colaboradorRepository.findAll(pageable).map(ListagemColaboradorDTO::new);
        return ResponseEntity.ok(lista);
    }

    @Operation(summary = "Mostra contribuições feitas por um determinado colaborador")
    @GetMapping("/{idColaborador}/contribuicoes")
    public ResponseEntity<DetalhesContribuicoesDTO> contribuicoesConcluidas(@PathVariable Long idColaborador){
        var colaborador = registroContribuicaoRepository.pesquisarPorContribuicoesFeitas(idColaborador);
        return ResponseEntity.ok().body(new DetalhesContribuicoesDTO(colaborador));
    }

    @Operation(summary = "Atribui uma contribuição ao colaborador")
    @PutMapping("/{idColaborador}/report/{idReport}")
    @Transactional
    public ResponseEntity<DetalhesColaboradorDTO> marcarComoConcluida(@RequestBody @Valid RegistroContribuicaoDTO dto, @PathVariable Long idColaborador, @PathVariable Long idReport){
        reportService.confirmarContribuicao(dto, idColaborador, idReport);
        var colaborador = colaboradorRepository.getReferenceById(idColaborador);
        return ResponseEntity.ok(new DetalhesColaboradorDTO(colaborador));
    }

    @Operation(summary = "Torna o colaborador inativo")
    @DeleteMapping("/{idColaborador}/inativo")
    @Transactional
    public ResponseEntity<Void> marcarColaboradorInativo(@PathVariable Long idColaborador){
        var colaborador = colaboradorRepository.getReferenceById(idColaborador);
        colaborador.marcarInativo();
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Lista todos os colaboradores inativos")
    @GetMapping("/inativos")
    public ResponseEntity<Page<ListagemColaboradorDTO>> mostrarColaboradoresInativos(@ParameterObject @PageableDefault(size = 5) Pageable pageable){
        var lista = colaboradorRepository.pesquisarColaboradoresInativos(pageable).map(ListagemColaboradorDTO::new);
        return ResponseEntity.ok(lista);
    }
}
