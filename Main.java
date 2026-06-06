package bancotaxas;

/**
 * Classe principal — demonstra o sistema refatorado com os mesmos testes
 * do sistema legado (Fases 1–3) e a extensão com Conta PJ (Fase 4).
 *
 * Observe que o código abaixo opera sobre a interface Conta, sem nunca
 * precisar saber qual tipo concreto está sendo usado — isso é polimorfismo.
 */
public class Main {

    public static void main(String[] args) {

        // ─── Instâncias das contas usando a interface Conta ──────────────────
        Conta corrente      = new ContaCorrente();
        Conta poupanca      = new ContaPoupanca();
        Conta universitaria = new ContaUniversitaria();
        Conta black         = new ContaBlack();

        System.out.println("=== SISTEMA REFATORADO - DEMONSTRAÇÃO ===\n");

        // ─── Teste 1: Conta Corrente ──────────────────────────────────────────
        System.out.println("--- Conta Corrente ---");
        System.out.println(new Transacao("TED",   500.00, 2000.00).descrever(corrente));
        System.out.println(new Transacao("PIX",   100.00, 2000.00).descrever(corrente));
        System.out.println(new Transacao("SAQUE", 200.00, 2000.00).descrever(corrente));

        // ─── Teste 2: Conta Poupança ──────────────────────────────────────────
        System.out.println("\n--- Conta Poupança ---");
        System.out.println(new Transacao("TED",   500.00, 3000.00).descrever(poupanca));
        System.out.println(new Transacao("SAQUE", 100.00, 3000.00).descrever(poupanca));

        // ─── Teste 3: Conta Universitária ────────────────────────────────────
        System.out.println("\n--- Conta Universitária ---");
        System.out.println(new Transacao("TED",    800.00, 1500.00).descrever(universitaria)); // TED <= 1000 → grátis
        System.out.println(new Transacao("TED",   1200.00, 1500.00).descrever(universitaria)); // TED > 1000 → R$0,50
        System.out.println(new Transacao("SAQUE",   50.00, 1500.00).descrever(universitaria));

        // ─── Teste 4: Conta Black ─────────────────────────────────────────────
        System.out.println("\n--- Conta Black ---");
        System.out.println(new Transacao("TED",   1000.00, 6000.00).descrever(black)); // saldo pós = 5000 → grátis
        System.out.println(new Transacao("TED",   2000.00, 5500.00).descrever(black)); // saldo pós = 3500 → R$10
        System.out.println(new Transacao("SAQUE",  300.00, 5100.00).descrever(black)); // saldo pós = 4800 → R$10

        // ─── FASE 4: Conta PJ — adicionada sem modificar nada acima ──────────
        System.out.println("\n=== EXTENSÃO — CONTA PJ ===\n");

        Conta pjPequena = new ContaPJ(50);   // empresa pequena: 50 funcionários
        Conta pjGrande  = new ContaPJ(150);  // empresa grande: 150 funcionários

        System.out.println("--- Conta PJ (50 funcionários) ---");
        System.out.println(new Transacao("TED",   1000.00, 5000.00).descrever(pjPequena));
        System.out.println(new Transacao("PIX",    500.00, 5000.00).descrever(pjPequena)); // PIX cobrado
        System.out.println(new Transacao("SAQUE",  300.00, 5000.00).descrever(pjPequena));

        System.out.println("\n--- Conta PJ (150 funcionários — PIX gratuito) ---");
        System.out.println(new Transacao("TED",   1000.00, 5000.00).descrever(pjGrande));
        System.out.println(new Transacao("PIX",    500.00, 5000.00).descrever(pjGrande)); // PIX gratuito
        System.out.println(new Transacao("SAQUE",  300.00, 5000.00).descrever(pjGrande));
    }
}
