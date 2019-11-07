package modal;

public class Estado {
    private int id;
    private String estado;

    public Estado(String estado) {
        this.id = 0;
        this.estado = estado;
    }
    
    public Estado() {
        this.id = 0;
        this.estado = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
