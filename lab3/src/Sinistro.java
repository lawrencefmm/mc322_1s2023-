import java.util.Random;
public class Sinistro {
    private final int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    // Construtor

    public Sinistro(String data, String endereco, Seguradora seguradora,
                    Veiculo veiculo, Cliente cliente) {

        this.id = generateId();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
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

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Sinistro{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", endereco='" + endereco + '\'' +
                ", seguradora=" + seguradora +
                ", veiculo=" + veiculo +
                ", cliente=" + cliente +
                '}';
    }
}
