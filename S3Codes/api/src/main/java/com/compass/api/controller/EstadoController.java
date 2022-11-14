package com.compass.api.controller;

import com.compass.api.controller.dto.EstadoDto;
import com.compass.api.controller.dto.EstadoSocioEconomicDto;
import com.compass.api.controller.form.AtualizacaoEstadoForm;
import com.compass.api.controller.form.EstadoForm;
import com.compass.api.modelo.Estado;
import com.compass.api.repository.EstadoRepository;
import com.compass.api.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private RegiaoRepository regiaoRepository;

    @GetMapping
    public Page<EstadoDto> lista(@RequestParam(required = false) String nomeRegiao, @PageableDefault(page = 0, size = 10)  Pageable paginacao){

        if(nomeRegiao == null){
            System.out.println(nomeRegiao);
            Page<Estado> estados = estadoRepository.findAll(paginacao);
            return EstadoDto.converte(estados);
        }
        System.out.println(nomeRegiao);
        Page<Estado> estados = estadoRepository.findByRegiaoNome(nomeRegiao,paginacao);
        return EstadoDto.converte(estados);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<EstadoSocioEconomicDto> cadastra(@RequestBody @Valid EstadoForm estadoForm, UriComponentsBuilder uriBuilder){
        Estado estado = estadoForm.converte(regiaoRepository);
        estadoRepository.save(estado);
        URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstadoSocioEconomicDto(estado));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstadoSocioEconomicDto> detalhar(@PathVariable Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        if(estado.isPresent()){
            return ResponseEntity.ok(new EstadoSocioEconomicDto(estado.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EstadoSocioEconomicDto>atualiza( @PathVariable Long id, @Valid @RequestBody  AtualizacaoEstadoForm form){
        Optional<Estado> optional = estadoRepository.findById(id);
        if(optional.isPresent()){
            Estado estado = form.atualizar(id, estadoRepository);
            return ResponseEntity.ok(new EstadoSocioEconomicDto(estado));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleta(@PathVariable Long id){
        Optional<Estado> optional = estadoRepository.findById(id);
        if(optional.isPresent()){
            estadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/socioeconomics")
    public Page<EstadoSocioEconomicDto> listaEstadosSocioEconomicsIndicators(@PageableDefault(page = 0, size = 10)  Pageable paginacao){
            Page<Estado> estados = estadoRepository.findAll(paginacao);
            return EstadoSocioEconomicDto.converte(estados);
    }
}
