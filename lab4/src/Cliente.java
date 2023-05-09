import java.util.ArrayList;

public class Cliente  {
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;

    // Construtor
    public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, double valorSeguro) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
        this.valorSeguro = valorSeguro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(Veiculo v) {
        listaVeiculos.add(v);
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public double calculaScore() {
        return CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.fatorIdade(dataNascimento) * getListaVeiculos().size();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", listaVeiculos=" + listaVeiculos +
                ", valorSeguro=" + valorSeguro +
                '}';
    }
}