package bancotaxas;

/**
 * Representa uma transação bancária.
 *
 * Responsabilidade única: guardar os dados de uma operação e saber
 * descrevê-la em conjunto com uma Conta.
 * Ela não conhece as regras de nenhum tipo de conta — delega isso
 * ao objeto Conta via polimorfismo.
 */
public class Transacao {

    private final String tipoTransacao;
    private final double valor;
    private final double saldoAtual;

    /**
     * @param tipoTransacao tipo da operação: "TED", "PIX" ou "SAQUE"
     * @param valor         valor da transação em reais
     * @param saldoAtual    saldo da conta antes da transação
     */
    public Transacao(String tipoTransacao, double valor, double saldoAtual) {
        // Normaliza para maiúsculas, eliminando o bug de case-sensitivity do sistema legado
        this.tipoTransacao = tipoTransacao.toUpperCase();
        this.valor = valor;
        this.saldoAtual = saldoAtual;
    }

    /**
     * Calcula a taxa desta transação para a conta fornecida.
     * Polimorfismo em ação: o método correto é escolhido em tempo de execução.
     *
     * @param conta a conta sobre a qual a transação será aplicada
     * @return taxa calculada pela própria conta
     */
    public double calcularTaxa(Conta conta) {
        return conta.calcularTaxa(tipoTransacao, valor, saldoAtual);
    }

    /**
     * Retorna uma descrição formatada da transação com sua taxa.
     *
     * @param conta a conta sobre a qual a transação será aplicada
     * @return string formatada para exibição
     */
    public String descrever(Conta conta) {
        double taxa = calcularTaxa(conta);
        return String.format("%s | %s | Valor: R$ %.2f | Taxa: R$ %.2f",
                conta.getNomeConta(), tipoTransacao, valor, taxa);
    }

    // ─── Getters ────────────────────────────────────────────────────────────

    public String getTipoTransacao() { return tipoTransacao; }
    public double getValor()         { return valor; }
    public double getSaldoAtual()    { return saldoAtual; }
}
