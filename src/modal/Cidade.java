package modal;

public class Cidade {
    private int id;
    private String cidade;

    public Cidade(String cidade) {
        this.id = 0;
        this.cidade = cidade;
    }
    
    public Cidade() {
        this.id = 0;
        this.cidade = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", cidade=" + cidade + '}';
    }
    
}
