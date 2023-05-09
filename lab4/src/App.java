import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;



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
                "638.827.680-61", dataNascimentoSample, 0);

        Cliente clientePj = new ClientePJ("Jorge & CIA", "Rua 0", listaVeiculosSample2,
                "12.345.678/9123-56", dataFundacaoSample, 0);

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

        ArrayList<Seguradora> ListaSeguradoras = new ArrayList<Seguradora>();
        ListaSeguradoras.add(seguradora);

        MenuOperacoes menu;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("##-------Seguradora Azul--------##\n\n");
            System.out.print("|--------------------------------|\n");
            System.out.print("| 1 - Cadastros                  |\n");
            System.out.print("| 2 - Listar                     |\n");
            System.out.print("| 3 - Excluir                    |\n");
            System.out.print("| 4 - Gerar Sinistro             |\n");
            System.out.print("| 5 - Transferir Seguro          |\n");
            System.out.print("| 6 - Calcular Receita           |\n");
            System.out.print("| 0 - Sair                       |\n");
            System.out.print("|--------------------------------|\n");
            System.out.print("Digite uma opção: ");
            menu = MenuOperacoes.values()[sc.nextInt()];

            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch (menu) {
                case CADASTRAR:
                    System.out.print("|--------------------------------|\n");
                    System.out.print("| 1 - Cadastrar Cliente PF/PJ    |\n");
                    System.out.print("| 2 - Cadastrar Veiculo          |\n");
                    System.out.print("| 3 - Cadastrar Seguradora       |\n");
                    System.out.print("| 4 - Voltar                     |\n");
                    System.out.print("|--------------------------------|\n");
                    System.out.print("Digite uma opção: ");
                    MenuCadastro menu_cadastro = MenuCadastro.values()[sc.nextInt() - 1];
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    switch (menu_cadastro) {
                        case CLIENTE:
                            System.out.print("|--------------------------------|\n");
                            System.out.print("| 1 - PF                         |\n");
                            System.out.print("| 2 - PJ                         |\n");
                            System.out.print("| 3 - Voltar                     |\n");
                            System.out.print("|--------------------------------|\n");
                            System.out.print("Digite uma opção: ");
                            int pessoa = sc.nextInt();
                            System.out.print(pessoa);
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            sc.nextLine();
                            if (pessoa == 1) {
                                System.out.print("nome: ");
                                String nome = sc.nextLine();
                                System.out.print("endereço: ");
                                String endereco = sc.nextLine();
                                System.out.print("educação: ");
                                String educacao = sc.nextLine();
                                System.out.print("genero: ");
                                String genero = sc.nextLine();
                                System.out.print("Classe Economica: ");
                                String classeEconomica = sc.nextLine();
                                System.out.print("cpf: ");
                                String cpf = sc.nextLine();
                                System.out.print("Data de Nascimento dd-mm-yyyy: ");
                                String data = sc.nextLine();
                                Date dataClienteNovo = formatter.parse(data);

                                Cliente novo_cliente = new ClientePF(nome, endereco, dataClienteNovo,
                                        educacao, genero, classeEconomica, new ArrayList<Veiculo>(),
                                        cpf, dataClienteNovo, 0);


                            }
                            else if (pessoa == 2) {
                                System.out.print("nome: ");
                                String nome = sc.nextLine();
                                System.out.print("endereço: ");
                                String endereco = sc.nextLine();
                                System.out.print("cnpj: ");
                                String cnpj = sc.nextLine();
                                System.out.print("Data de Fundacao dd-mm-yyyy: ");
                                String data = sc.nextLine();
                                Date dataClienteNovo = formatter.parse(data);
                                Cliente novo_cliente = new ClientePJ(nome, endereco, new ArrayList<Veiculo>(),
                                        cnpj, dataClienteNovo, 0);
                            }
                            break;
                        case VEICULO:
                            String placa = sc.nextLine();
                            System.out.print("nome: ");
                            String marca = sc.nextLine();
                            System.out.print("endereço: ");
                            String modelo = sc.nextLine();
                            System.out.print("anoFabricacao: ");
                            int anoFabricacao = sc.nextInt();
                            Veiculo novoVeiculo = new Veiculo(placa, marca, modelo, anoFabricacao);

                            System.out.print("nome do cliente: ");
                            String nome_cliente = sc.nextLine();
                            break;
                        case SEGURADORA:
                            break;
                        case SAIR:
                            break;

                    }
                    break;
                case LISTAR:
                    System.out.print("|-------------------------------------|\n");
                    System.out.print("| 1 - Listar Cliente PF/PJ por Seg    |\n");
                    System.out.print("| 2 - Listar Sinistros por Seg        |\n");
                    System.out.print("| 3 - Listar Sinistro por Cliente     |\n");
                    System.out.print("| 4 - Listar Veiculo por Cliente      |\n");
                    System.out.print("| 5 - Listar Veiculo por Seg          |\n");
                    System.out.print("| 6 - Voltar                          |\n");
                    System.out.print("|-------------------------------------|\n");
                    System.out.print("Digite uma opção: ");
                    MenuListar menuListar = MenuListar.values()[sc.nextInt()];
                    System.out.println(menuListar);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    switch (menuListar) {
                        case CLIENTE_SEG:
                            System.out.print("Digite o nome da seguradora: ");
                            String nome_seg = sc.nextLine();
                            for (Seguradora seg : ListaSeguradoras) {
                                if (seg.getNome() == nome_seg) {
                                    seg.listarClientes("ClientePF");
                                    seg.listarClientes("ClientePJ");
                                }
                            }
                            break;
                        case SINISTRO_SEG:
                            System.out.print("Digite o nome da seguradora: ");
                            String nome_segg = sc.nextLine();
                            for (Seguradora seg : ListaSeguradoras) {
                                if (seg.getNome() == nome_segg) {
                                    seg.listarSinistros();
                                }
                            }
                            break;
                        case SINISTRO_CLIENTE:
                            System.out.print("Digite o nome do cliente: ");
                            String nome_cliente = sc.nextLine();
                            for (Seguradora seg : ListaSeguradoras) {
                                for(Sinistro s : seg.getListaSinistros()) {
                                    if(s.getCliente().getNome() == nome_cliente) {
                                        System.out.print(s);
                                        System.out.print("\n");
                                    }
                                }
                            }
                            break;
                        case VEICULO_CLIENTE:
                            System.out.print("Digite o nome do cliente: ");
                            String nome_cliente_vec = sc.nextLine();
                            for(Cliente cli: listaCLientes) {
                                if(cli.getNome() == nome_cliente_vec) {
                                    for(Veiculo vec : cli.getListaVeiculos()) {
                                        System.out.println(vec + ", ");
                                        System.out.println("\n");
                                    }
                                }
                            }
                            break;
                        case VEICULO_SEG:
                            System.out.print("Digite o nome da seguradora: ");
                            String nome_segu = sc.nextLine();
                            for (Seguradora seg : ListaSeguradoras) {
                                if (seg.getNome() == nome_segu) {
                                    for (Cliente cli: seg.getListaClientes()) {
                                        for(Veiculo vec : cli.getListaVeiculos()) {
                                            System.out.println(vec + ", ");

                                        }
                                    }
                                }
                            }
                            System.out.println("\n");
                            break;
                        case SAIR:
                            break;
                    }
                    break;
                case EXCLUIR:
                    System.out.print("|--------------------------------|\n");
                    System.out.print("| 1 - Excluir Cliente            |\n");
                    System.out.print("| 2 - Excluir Veiculo            |\n");
                    System.out.print("| 3 - Excluir Sinistro           |\n");
                    System.out.print("| 4 - Voltar                     |\n");
                    System.out.print("|--------------------------------|\n");
                    System.out.print("Digite uma opção: ");
                    MenuExcluir menuExcluir = MenuExcluir.values()[sc.nextInt()];

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    switch (menuExcluir) {
                        case CLIENTE:
                            break;
                        case VEICULO:
                            break;
                        case SINISTRO:
                            break;
                        case SAIR:
                            break;

                    }
                    break;
                case GERAR_SINISTRO:
                    System.out.print("quatro");
                    break;
                case TRANSFERIR_SEGURO:
                    System.out.print("cinco");
                    break;
                case CALCULAR_RECEITA:
                    System.out.print("seis");
                    break;
                case SAIR:
                    System.out.print("zero...");
                    return;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
