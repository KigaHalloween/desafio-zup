package br.com.zup.desafio.controller;

import br.com.zup.desafio.dto.PessoaDTO;
import br.com.zup.desafio.entity.Pessoa;

import br.com.zup.desafio.mapper.PessoaMapper;
import br.com.zup.desafio.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    private PessoaService service;
    private PessoaMapper mapper;

    public PessoaController(PessoaService service, PessoaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody @Valid PessoaDTO request){
        Pessoa entidade = mapper.converterPessoaParaEntidade(request);
        service.salvar(entidade);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public void buscarDados(){
        System.out.println("buscar dados");
    }

    @PutMapping()
    public void alterarDados(){
        System.out.println("alterar dados");
    }
}
