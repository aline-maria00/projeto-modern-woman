package modal;

public class Email {
    private String cpf;
    private String email;
    private String atributoAleatorio;

    public Email(String cpf, String email) {
        this.cpf = cpf;
        this.email = email;
    }
    
    public Email() {
        this.cpf = "";
        this.email = "";
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
    
}
