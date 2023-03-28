import java.util.Random;
public class Sinistro {
    private int id;
    private String data;
    private String endereco;

    // Construtor
    public Sinistro(String data, String endereco) {
        this.id = generateId();
        this.data = data;
        this.endereco = endereco;
    }

    // Metodos
    public static int generateId() {
        Random random = new Random();
        int _id = 0;
        for (int i = 0; i < 10; i++) {
            _id = _id * 10 + random.nextInt(10);
        }
        return _id;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId() {
        this.id = generateId();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
