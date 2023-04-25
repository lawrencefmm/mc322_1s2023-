import java.util.function.Function;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Cliente  {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private int idade;

    // Construtor
    public Cliente(String nome, String cpf, String dataNascimento, String endereco, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.idade = calculaIdade(dataNascimento);
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

        if (digito1 != cpf.charAt(9)) return false;

        sum = 0;
        for(int i = 0, mod = 11; i < 9; i++, mod--) sum += mod * (cpf.charAt(i) - '0');
        sum += digito1 * 2;
        sum %= 11;
        digito2 = sum % 10;
        if (digito2 != cpf.charAt(10)) return false;

        return true;
    }
    private static int calculaIdade(String dataNascimento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(dataNascimento, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(!validarCPF(cpf)) {
            System.out.println("Erro no formato do cpf");
            return;
        }
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.idade = calculaIdade(dataNascimento);
    }

}