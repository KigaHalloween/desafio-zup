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

    public PessoaDTO convertePessoaParaDTO(Pessoa parametro){
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome(parametro.getNome());
        pessoaDTO.setCpf(parametro.getCpf());
        pessoaDTO.setEmail(parametro.getEmail());
        pessoaDTO.setDataNascimento(parametro.getDataNascimento());
        pessoaDTO.setId(parametro.getId());
        return pessoaDTO;
    }
}
