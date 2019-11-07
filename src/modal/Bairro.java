package modal;

public class Bairro {
    private int id;
    private String bairro;

    public Bairro(String bairro) {
        this.id = 0;
        this.bairro = bairro;
    }
    
    public Bairro() {
        this.id = 0;
        this.bairro = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Bairro{" + "id=" + id + ", bairro=" + bairro + '}';
    }
}
