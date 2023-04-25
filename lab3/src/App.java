import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws Exception {
        // Samples que serao utilizados nos testes
        Veiculo veiculoSample1 = new Veiculo("ABC2023", "Chevy", "Tron", 2020);
        Veiculo veiculoSample2 = new Veiculo("XDD1999", "Volky", "Apex", 2015);

        ArrayList<Veiculo> listaVeiculosSample1 = new ArrayList<Veiculo>();
        ArrayList<Veiculo> listaVeiculosSample2 = new ArrayList<Veiculo>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dataNascimentoSample = formatter.parse("01-01-2000");
        Date dataFundacaoSample = formatter.parse("06-04-1999");
        listaVeiculosSample1.add(veiculoSample1);
        listaVeiculosSample2.add(veiculoSample2);


        // Cliente instanciado
        Cliente clientePf = new ClientePF("Cleber", "Rua 1", dataNascimentoSample,
                "Superior", "H", "Alta", listaVeiculosSample1,
                "638.827.680-61", dataNascimentoSample);

        Cliente clientePj = new ClientePJ("Jorge & CIA", "Rua 0", listaVeiculosSample2,
                "12.345.678/9123-56", dataFundacaoSample);

        // Seguradora instanciada
        Seguradora seguradora = new Seguradora("Joao Seguros", "(19) 98756-4321",
                "contato@joaoseguros.com.br", "Rua 2", new ArrayList<Sinistro>(),
                new ArrayList<Cliente>());

        // Cadastrando clientes
        seguradora.cadastrarCliente(clientePj);
        seguradora.cadastrarCliente(clientePf);
        seguradora.gerarSinistro("14-06-2023", "Rua 60", seguradora,
                veiculoSample1, clientePf);

        seguradora.listarClientes("ClientePF");
        seguradora.listarClientes("ClientePJ");
        seguradora.listarSinistros();
        seguradora.visualizarSinistro("Cleber");
    }
}
