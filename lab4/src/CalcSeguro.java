import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public enum CalcSeguro {
    VALOR_BASE(100.0),
    FATOR_18_30(1.2),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    private final double valor;

    CalcSeguro(double v) {
        this.valor = v;
    }

    public double getValor() {
        return valor;
    }

    public static double fatorIdade(Date dataNascimento) {
        int anosIdade = Period.between(dataNascimento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), LocalDate.now()).getYears();
        if (anosIdade < 30)
            return FATOR_18_30.getValor();
        else if (anosIdade < 60)
            return FATOR_30_60.getValor();
        return FATOR_60_90.getValor();
    }
}