import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente  {
    private final String cnpj;
    private Date dataFundacao;
    private int qtdFuncionarios;

    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos,
                     String cnpj, Date dataFundacao, double valorSeguro) {
        super(nome, endereco, listaVeiculos, valorSeguro);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    // Metodos
    private static boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) return false;


        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int num = cnpj.charAt(i) - '0';
            soma += num * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int num = cnpj.charAt(i) - '0';
            soma += num * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        return Character.getNumericValue(cnpj.charAt(12)) == digito1
                && Character.getNumericValue(cnpj.charAt(13)) == digito2;
    }

    // Getters e setters

    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    @Override
    public String toString() {
        return "ClientePJ{" +
                "cnpj='" + cnpj + '\'' +
                ", dataFundacao=" + dataFundacao +
                ", qtdFuncionarios=" + qtdFuncionarios +
                "} " + super.toString();
    }

    @Override
    public double calculaScore() {
        return CalcSeguro.VALOR_BASE.getValor() * (1 + ( Double.parseDouble(String.valueOf(qtdFuncionarios)) ) /100) * getListaVeiculos().size();
    }
}