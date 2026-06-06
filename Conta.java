package bancotaxas;

/**
 * Contrato que todo tipo de conta do Banco NXT deve cumprir.
 *
 * O uso de interface garante:
 *  - Nenhuma lógica compartilhada desnecessária entre contas diferentes.
 *  - Máxima extensibilidade: novas contas são criadas implementando
 *    esta interface, sem modificar nada existente (Princípio Aberto/Fechado).
 *  - Polimorfismo: o restante do sistema opera sobre "Conta" sem
 *    precisar saber qual tipo concreto está usando.
 */
public interface Conta {

    /**
     * Calcula a taxa de uma transação para este tipo de conta.
     *
     * @param tipoTransacao tipo da operação: "TED", "PIX" ou "SAQUE"
     * @param valor         valor da transação em reais
     * @param saldoAtual    saldo da conta antes da transação ser efetuada
     * @return              valor da taxa a ser cobrada (0.0 se isenta)
     */
    double calcularTaxa(String tipoTransacao, double valor, double saldoAtual);

    /**
     * Retorna o nome formatado deste tipo de conta para exibição.
     *
     * @return nome do tipo de conta (ex.: "Corrente", "Black", "PJ")
     */
    String getNomeConta();
}
