package modal;

public class Endereco
{    
    private int id;
    private String logradouro;
    private String numero;
    private Bairro bairro;
    private Cidade cidade;
    private Estado estado;

    public Endereco(String logradouro, String numero, Bairro bairro, Cidade cidade, Estado estado) {
        this.id = 0;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public Endereco() {
        this.id = 0;
        this.logradouro = "";
        this.numero = "";
        this.bairro = new Bairro();
        this.cidade = new Cidade();
        this.estado = new Estado();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
