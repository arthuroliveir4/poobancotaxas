package bancotaxas;

/**
 * Conta Black (VIP) — regras de taxa:
 *  - Todas as transações são gratuitas SE o saldo pós-transação
 *    permanecer igual ou acima de R$ 5.000,00.
 *  - Cobra R$ 10,00 caso o saldo caia abaixo desse limite.
 *
 * Nota: a regra não depende do tipo de transação, apenas do saldo resultante.
 */
public class ContaBlack implements Conta {

    private static final double SALDO_MINIMO     = 5000.00;
    private static final double TAXA_PENALIDADE  = 10.00;

    @Override
    public double calcularTaxa(String tipoTransacao, double valor, double saldoAtual) {
        double saldoAposTransacao = saldoAtual - valor;
        return saldoAposTransacao < SALDO_MINIMO ? TAXA_PENALIDADE : 0.0;
    }

    @Override
    public String getNomeConta() {
        return "Black";
    }
}
