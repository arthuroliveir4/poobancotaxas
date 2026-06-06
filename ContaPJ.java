package bancotaxas;

/**
 * FASE 4 — EXTENSÃO: Conta PJ (Pessoa Jurídica).
 *
 * Esta classe foi adicionada SEM modificar nenhuma classe existente,
 * respeitando plenamente o Princípio Aberto/Fechado.
 *
 * Regras de taxa:
 *  - TED:   R$ 1,20
 *  - PIX:   R$ 0,90 (GRATUITO se a empresa tiver mais de 100 funcionários)
 *  - SAQUE: R$ 2,00
 */
public class ContaPJ implements Conta {

    /** Limite de funcionários a partir do qual o PIX é gratuito. */
    private static final int LIMITE_FUNCIONARIOS_PIX_GRATIS = 100;

    private final int numeroFuncionarios;

    /**
     * @param numeroFuncionarios número de funcionários da empresa titular da conta
     */
    public ContaPJ(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double calcularTaxa(String tipoTransacao, double valor, double saldoAtual) {
        switch (tipoTransacao) {
            case "TED":
                return 1.20;
            case "PIX":
                return numeroFuncionarios > LIMITE_FUNCIONARIOS_PIX_GRATIS ? 0.0 : 0.90;
            case "SAQUE":
                return 2.00;
            default:
                return 0.0;
        }
    }

    @Override
    public String getNomeConta() {
        return "PJ";
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }
}
