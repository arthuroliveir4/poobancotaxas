package bancotaxas;

/**
 * Conta Poupança — regras de taxa:
 *  - TED:   gratuito
 *  - PIX:   gratuito
 *  - SAQUE: R$ 0,50
 */
public class ContaPoupanca implements Conta {

    @Override
    public double calcularTaxa(String tipoTransacao, double valor, double saldoAtual) {
        if (tipoTransacao.equals("SAQUE")) {
            return 0.50;
        }
        return 0.0; // TED e PIX são gratuitos na Poupança
    }

    @Override
    public String getNomeConta() {
        return "Poupanca";
    }
}
