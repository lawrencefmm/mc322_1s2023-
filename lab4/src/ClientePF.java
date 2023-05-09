import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente  {
    private final String cpf;
    private Date dataNascimento;
    private Date dataLicenca;
    private String educacao;
    private String classeEconomica;
    private String genero;

    // Construtor
    public ClientePF (String nome, String endereco, Date dataLicenca,
        String educacao, String genero, String classeEconomica,
        ArrayList<Veiculo> listaVeiculos, String cpf, Date dataNascimento,
                      double valorSeguro) throws Exception {

        super(nome, endereco, listaVeiculos, valorSeguro);
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;

        if (validarCPF(cpf)) this.cpf = cpf;
        else throw new Exception("CPF Invalido");

        this.dataNascimento = dataNascimento;
    }

    // Metodos
    private static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return false;

        if (cpf.chars().distinct().count() == 1) return false;

        int digito1, digito2;
        int sum = 0;
        for(int i = 0, mod = 10; i < 9; i++, mod--) sum += mod * (cpf.charAt(i) - '0');
        sum %= 11;
        digito1 = sum < 2 ? 0 : 11 - sum;
        if (digito1 != (cpf.charAt(9) - '0')) return false;

        sum = 0;
        for(int i = 0, mod = 11; i < 9; i++, mod--) sum += mod * (cpf.charAt(i) - '0');
        sum += digito1 * 2;
        sum %= 11;
        digito2 = sum < 2 ? 0 : 11 - sum;
        if (digito2 != (cpf.charAt(10) - '0')) return false;

        return true;
    }

    // Getters e setters
    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }
    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }
    public String getEducacao() {
        return educacao;
    };

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "ClientePF{" +
                "cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataLicenca=" + dataLicenca +
                ", educacao='" + educacao + '\'' +
                ", classeEconomica='" + classeEconomica + '\'' +
                ", genero='" + genero + '\'' +
                "} " + super.toString();
    }

    @Override
    public double calculaScore() {
        return CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.fatorIdade(dataNascimento) * getListaVeiculos().size();
    }
}