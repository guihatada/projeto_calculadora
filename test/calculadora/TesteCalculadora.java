package calculadora;

/**
 * Testes unitários simples executados via método main.
 * Os seis casos usam as entradas do slide 42 da aula.
 * Sem dependência da biblioteca JUnit.
 *
 * @author Seu Nome
 * @version 1.0
 */
public class TesteCalculadora {

    /** Quantidade de testes aprovados. */
    private static int aprovados = 0;

    /** Quantidade de testes reprovados. */
    private static int reprovados = 0;

    /** Impede instanciar uma classe de testes utilitários. */
    private TesteCalculadora() { }

    /**
     * Exibe entrada, resultado esperado e resultado obtido; compara os valores.
     *
     * @param nome descrição do teste
     * @param entrada combinação de operandos e operador
     * @param esperado resultado inteiro esperado
     * @param obtido resultado inteiro recebido do programa
     */
    private static void verificar(String nome, String entrada, int esperado, int obtido) {
        boolean passou = esperado == obtido;
        if (passou) aprovados++; else reprovados++;
        System.out.printf("[%s] %s | Entrada: %s | Esperado: %d | Obtido: %d%n",
                passou ? "APROVADO" : "REPROVADO", nome, entrada, esperado, obtido);
    }

    /**
     * Executa seis cenários exigidos no enunciado.
     *
     * @param args argumentos de linha de comando não utilizados
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Cenários originais do slide 42, agora com comparação automática.
        verificar("Soma", "2 + 3", 5, calc.calc(2, 3, "+"));
        verificar("Subtracao", "10 - 4", 6, calc.calc(10, 4, "-"));
        verificar("Multiplicacao", "3 * 5", 15, calc.calc(3, 5, "*"));
        verificar("Divisao", "8 / 2", 4, calc.calc(8, 2, "/"));
        verificar("Divisao por zero", "8 / 0", 0, calc.calc(8, 0, "/"));
        verificar("Operacao invalida", "5 x 5", 0, calc.calc(5, 5, "x"));

        System.out.printf("RESUMO: %d APROVADOS | %d REPROVADOS%n", aprovados, reprovados);
        if (reprovados > 0) System.exit(1);
    }
}
