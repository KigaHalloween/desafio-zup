package br.com.zup.desafio.services;

import br.com.zup.desafio.entity.Pessoa;
import br.com.zup.desafio.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public void salvar(Pessoa entidade){
        repository.save(entidade);
    }
}
