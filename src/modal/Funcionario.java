package modal;

public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private Telefone telefone;
    private Email email;
    private Endereco endereco;

    public Funcionario(String nome, String cpf, String rg, Telefone telefone, Email email, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco + '}';
    }
    
    
    
    public Funcionario() {
        this.id = 0;
        this.nome = "";
        this.cpf = "";
        this.rg = "";
        this.telefone = new Telefone();
        this.endereco = new Endereco();
        this.email = new Email();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}