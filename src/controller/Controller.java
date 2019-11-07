package controller;

import modal.Funcionario;
import modal.FuncionarioDAO;
import modal.Telefone;
import modal.Email;
import modal.Estado;
import modal.Cidade;
import modal.Bairro;
import modal.Endereco;

public class Controller {
    
    Telefone telefone;
    Email email;
    Estado estado;
    Cidade cidade;
    Bairro bairro;
    Endereco endereco;
    Funcionario funcionario;
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public Boolean cadastroFuncionario(String nome, String cpf, String rg, String telefone, String email, String logradouro, String numero, String bairro, String cidade, String estado) {
        this.telefone = new Telefone(cpf, telefone);
        this.email = new Email(cpf, email);
        this.estado = new Estado(estado);
        this.cidade = new Cidade(cidade);
        this.bairro = new Bairro(bairro);
        this.endereco = new Endereco(logradouro, numero, this.bairro, this.cidade, this.estado);
        this.funcionario = new Funcionario(nome, cpf, rg, this.telefone, this.email, this.endereco);
        this.funcionarioDAO.cadastroDeFuncionario(funcionario);
        return true;
    }
}
