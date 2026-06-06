package bancotaxas;

/**
 * Conta Corrente — regras de taxa:
 *  - TED:   R$ 0,50
 *  - PIX:   R$ 0,30
 *  - SAQUE: R$ 1,50
 */
public class ContaCorrente implements Conta {

    @Override
    public double calcularTaxa(String tipoTransacao, double valor, double saldoAtual) {
        switch (tipoTransacao) {
            case "TED":   return 0.50;
            case "PIX":   return 0.30;
            case "SAQUE": return 1.50;
            default:      return 0.0;
        }
    }

    @Override
    public String getNomeConta() {
        return "Corrente";
    }
}
