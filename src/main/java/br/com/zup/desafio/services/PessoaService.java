package br.com.zup.desafio.services;

import br.com.zup.desafio.entity.Pessoa;
import br.com.zup.desafio.repository.PessoaRepository;
import br.com.zup.desafio.validation.PessoaNaoEncontradaException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa salvar(Pessoa entidade){
        Boolean existaPessoa = repository.existsByCpfOrEmail(entidade.getCpf(), entidade.getEmail());
        if(existaPessoa) {
           throw new PessoaNaoEncontradaException();
        }
        return repository.save(entidade);
    }
}
