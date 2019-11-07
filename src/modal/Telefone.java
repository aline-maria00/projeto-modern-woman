package modal;

public class Telefone {
    private String cpf;
    private String telefone;

    public Telefone(String cpf, String telefone) {
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    public Telefone() {
        this.cpf = "";
        this.telefone = "";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
