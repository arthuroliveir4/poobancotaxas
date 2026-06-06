package bancotaxas;

/**
 * Conta Universitária — regras de taxa:
 *  - TED:   gratuito para valores até R$ 1.000,00; R$ 0,50 acima disso
 *  - PIX:   gratuito
 *  - SAQUE: R$ 0,80
 */
public class ContaUniversitaria implements Conta {

    /** Limite acima do qual o TED deixa de ser gratuito. */
    private static final double LIMITE_TED_GRATUITO = 1000.00;

    @Override
    public double calcularTaxa(String tipoTransacao, double valor, double saldoAtual) {
        switch (tipoTransacao) {
            case "TED":   return valor > LIMITE_TED_GRATUITO ? 0.50 : 0.0;
            case "PIX":   return 0.0;
            case "SAQUE": return 0.80;
            default:      return 0.0;
        }
    }

    @Override
    public String getNomeConta() {
        return "Universitaria";
    }
}
