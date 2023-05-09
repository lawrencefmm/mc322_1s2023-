import java.lang.reflect.Array;
import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    ArrayList<Sinistro> listaSinistros;
    ArrayList<Cliente> listaClientes;

    // Construtor

    public Seguradora(String nome, String telefone, String email,
                      String endereco, ArrayList<Sinistro> listaSinistros,
                      ArrayList<Cliente> listaClientes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = listaSinistros;
        this.listaClientes = listaClientes;
    }

    // Metodos
    public boolean cadastrarCliente(Cliente cliente) {
        try {
            listaClientes.add(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removerCliente(Cliente cliente) {
        try {
            listaClientes.remove(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void listarClientes(String tipoCliente) {
        for (Cliente cliente : listaClientes) {
            String tipo = cliente.getClass().getName();
            if (tipo == tipoCliente)
                System.out.println(cliente + "\n");
        }
    }

    public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        try {
            Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
            listaSinistros.add(sinistro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean visualizarSinistro(String cliente) {
        try {
            for (Sinistro sinistro : listaSinistros) {
                if(sinistro.getCliente().getNome() == cliente)
                    System.out.println(sinistro + "\n");
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void listarSinistros() {
        for(Sinistro sinistro : listaSinistros) {
            System.out.println(sinistro +  "\n");
        }
    }

    public double calcularPrecoSeguroCliente(String nome) {
        int quantidade_de_sinistros = 0;
        for(Sinistro s : listaSinistros) {
            if(s.getCliente().getNome() == nome) {
                quantidade_de_sinistros++;
            }
        }
        double preco = 0;
        for(Cliente cli : listaClientes) {
            if(cli.getNome() == nome) {
                preco = cli.calculaScore() * (1 + quantidade_de_sinistros);
            }
        }
        return preco;
    }


    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
