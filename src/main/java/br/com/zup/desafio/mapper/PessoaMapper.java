package br.com.zup.desafio.mapper;

import br.com.zup.desafio.dto.PessoaDTO;
import br.com.zup.desafio.entity.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public Pessoa converterPessoaParaEntidade(PessoaDTO parametro){
        Pessoa entidadePessoa = new Pessoa();
        entidadePessoa.setNome(parametro.getNome());
        entidadePessoa.setCpf(parametro.getCpf());
        entidadePessoa.setEmail(parametro.getEmail());
        entidadePessoa.setDataNascimento(parametro.getDataNascimento());
        return entidadePessoa;
    }
}
