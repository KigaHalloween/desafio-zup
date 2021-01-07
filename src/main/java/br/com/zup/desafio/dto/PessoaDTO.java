package br.com.zup.desafio.dto;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class PessoaDTO {
    private Long id;
    @NotNull(message = "Nome é um atributo obrigatório")
    private String nome;
    @NotNull(message = "CPF é um atributo obrigatório")
    private String cpf;
    @NotNull(message = "E-mail é um atributo obrigatório")
    private String email;
    @NotNull(message = "Data de nascimento é um atributo obrigatório")
    private LocalDate dataNascimento;

    public PessoaDTO(String nome, String cpf, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public PessoaDTO() { }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
